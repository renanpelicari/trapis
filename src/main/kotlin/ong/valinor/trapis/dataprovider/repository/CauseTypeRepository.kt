package ong.valinor.trapis.dataprovider.repository

import ong.valinor.trapis.dataprovider.domain.CauseType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface CauseTypeRepository: JpaRepository<CauseType, Long> {

    fun findByNameIgnoreCase(name: String): CauseType?
}
