package ong.valinor.trapis.dataprovider.entity

import org.springframework.data.annotation.Id
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "T_CAUSE")
data class CauseEntity(

        @Id
        @Column(name = "CAUSE_ID", unique = true, nullable = false)
        val causeId: Long?,

        @Column(name = "CAUSE", nullable = false)
        val cause: String,

        @Column(name = "DESCRIPTION", nullable = false)
        val description: String,

        @Column(name = "CREATED_AT", nullable = false)
        val createdAt: ZonedDateTime,

        @OneToOne
        val causeTypeEntity: CauseTypeEntity
)
