package ong.valinor.trapis.business.usecases.impl

import ong.valinor.trapis.business.usecases.RegisterCauseUseCase
import ong.valinor.trapis.dataprovider.domain.Cause
import ong.valinor.trapis.dataprovider.repository.CauseRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RegisterCauseUseCaseImpl(private val causeRepository: CauseRepository,
                               private val findOrSaveCauseTypeByNameUseCaseImpl: FindOrSaveCauseTypeByNameUseCaseImpl)
    : RegisterCauseUseCase {

    /**
     * @see RegisterCauseUseCase.execute
     */
    override fun execute(cause: Cause): Cause {

        val causeTypes = cause.causeTypes.map {
            findOrSaveCauseTypeByNameUseCaseImpl.execute(it.name)
        }

        return causeRepository.save(
                Cause(
                        name = cause.name,
                        causeTypes = causeTypes,
                        description = cause.description
                )
        )
    }
}
