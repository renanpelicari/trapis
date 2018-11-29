package ong.valinor.trapis.dataprovider.entity

import javax.persistence.*


@Entity
@Table(name = "T_CAUSE_TYPE")
data class CauseTypeEntity(

        @Id
        @Column(name = "CAUSE_TYPE_ID", unique = true, nullable = false)
        val causeTypeId: Long,

        @Column(name = "CAUSE_TYPE", unique = true, nullable = false)
        val causeType: String
)
