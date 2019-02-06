package ong.valinor.trapis.dataprovider.repository

import ong.valinor.trapis.dataprovider.domain.Cause
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Repository
interface CauseRepository: JpaRepository<Cause, Long>
