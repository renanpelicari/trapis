package ong.valinor.trapis.business.usecases.impl

import ong.valinor.trapis.business.usecases.RegisterCauseUseCase
import ong.valinor.trapis.dataprovider.domain.Cause
import ong.valinor.trapis.dataprovider.repository.CauseRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RegisterCauseUseCaseImpl(private val causeRepository: CauseRepository,
                               private val findOrSaveCauseTypeByNameUseCaseImpl: FindOrSaveCauseTypeByNameUseCaseImpl)
    : RegisterCauseUseCase {

    /**
     * @see RegisterCauseUseCase.execute
     */
    override fun execute(cause: Cause): Cause {

        val causeType = findOrSaveCauseTypeByNameUseCaseImpl.execute(
                causeTypeName = cause.causeType.name
        )

        return causeRepository.saveAndFlush(
                Cause(
                        name = cause.name,
                        causeType = causeType,
                        description = cause.description
                )
        )
    }
}
