package ong.valinor.trapis.dataprovider.domain

import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "T_CAUSE")
data class Cause(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "CAUSE_ID", unique = true, nullable = false)
        val causeId: Long? = null,

        @Column(name = "NAME", nullable = false)
        val name: String,

        @Column(name = "DESCRIPTION", nullable = false)
        val description: String,

        @Column(name = "CREATED_AT", nullable = false)
        val createdAt: ZonedDateTime = ZonedDateTime.now(),

        @OneToOne
        val causeType: CauseType
)

@Entity
@Table(name = "T_CAUSE_TYPE")
data class CauseType(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "CAUSE_TYPE_ID", unique = true, nullable = false)
        val causeTypeId: Long? = null,

        @Column(name = "NAME", unique = true, nullable = false)
        val name: String
)
