package ong.valinor.trapis.dataprovider.domain

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "T_CAUSE")
data class Cause(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CAUSE_ID", unique = true, columnDefinition = "serial")
        val id: Long? = null,

        @Column(name = "NAME", nullable = false, length = 120)
        val name: String,

        @Column(name = "DESCRIPTION", nullable = false, length = 500)
        val description: String,

        @Column(name = "CREATED_AT", nullable = false)
        val createdAt: ZonedDateTime = ZonedDateTime.now(),

        @Column(name = "DEADLINE")
        val deadline: ZonedDateTime? = null,

        @Column(name = "PLEDGED")
        val pledged: BigDecimal? = null,

        @Column(name = "BUDGET_REACHED")
        val budgetReached: BigDecimal? = null,

        @Column(name = "BACKERS_COUNTER", nullable = false)
        val backersCounter: Int = 0,

        @ManyToMany
        @JoinTable(
                name = "T_CAUSE_CAUSE_TYPE",
                joinColumns = [(JoinColumn(name = "CAUSE_ID", referencedColumnName = "CAUSE_ID"))],
                inverseJoinColumns = [(JoinColumn(name = "CAUSE_TYPE_ID", referencedColumnName = "CAUSE_TYPE_ID"))]
        )
        val causeTypes: List<CauseType>
)

@Entity
@Table(name = "T_CAUSE_TYPE")
data class CauseType(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CAUSE_TYPE_ID", unique = true, columnDefinition = "serial")
        val id: Long? = null,

        @Column(name = "NAME", unique = true, nullable = false, length = 50)
        val name: String
)
