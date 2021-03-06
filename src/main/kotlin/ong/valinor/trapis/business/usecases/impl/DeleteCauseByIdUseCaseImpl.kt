package ong.valinor.trapis.business.usecases.impl

import ong.valinor.trapis.business.exceptions.CouldNotDeleteEntityDueIdNotFound
import ong.valinor.trapis.business.usecases.DeleteCauseByIdUseCase
import ong.valinor.trapis.dataprovider.repository.CauseRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DeleteCauseByIdUseCaseImpl(private val causeRepository: CauseRepository) : DeleteCauseByIdUseCase {

    /**
     * @see DeleteCauseByIdUseCase.execute
     */
    override fun execute(causeId: Long) =
            try {
                causeRepository.deleteById(causeId)
            } catch (e: EmptyResultDataAccessException) {
                throw CouldNotDeleteEntityDueIdNotFound(entityName = "Cause", entityId = causeId)
            }

}
