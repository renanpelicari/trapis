package ong.valinor.trapis.business.usecases.impl

import ong.valinor.trapis.business.usecases.FetchCausesUseCase
import ong.valinor.trapis.dataprovider.domain.Cause
import ong.valinor.trapis.dataprovider.repository.CauseRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FetchCausesUseCaseImpl(private val causeRepository: CauseRepository) : FetchCausesUseCase {

    /**
     * @see FetchCausesUseCase.execute
     */
    override fun execute(): MutableList<Cause> = causeRepository.findAll()
}
