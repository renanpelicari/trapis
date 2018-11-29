package ong.valinor.trapis.business.usecases.impl

import ong.valinor.trapis.business.usecases.FindOrSaveCauseTypeByNameUseCase
import ong.valinor.trapis.dataprovider.domain.CauseType
import ong.valinor.trapis.dataprovider.repository.CauseTypeRepository
import org.springframework.stereotype.Service

@Service
class FindOrSaveCauseTypeByNameUseCaseImpl(
        private val causeTypeRepository: CauseTypeRepository): FindOrSaveCauseTypeByNameUseCase {

    /**
     * @see FindOrSaveCauseTypeByNameUseCase.execute
     */
    override fun execute(causeTypeName: String): CauseType {
        return causeTypeRepository.findByName(causeTypeName)
            ?: causeTypeRepository.save(CauseType(name = causeTypeName))
    }
}
