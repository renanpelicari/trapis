package ong.valinor.trapis.entrypoint.vo

import ong.valinor.trapis.dataprovider.domain.Cause
import ong.valinor.trapis.dataprovider.domain.CauseType
import java.math.BigDecimal
import java.time.ZonedDateTime

data class CauseRequestVo(
        val name: String,
        val description: String,
        val deadline: ZonedDateTime?,
        val pledged: BigDecimal?,
        val tags: List<String>
)

data class CauseResponseVo(
        val id: Long,
        val name: String,
        val description: String,
        val createdAt: ZonedDateTime,
        val deadline: ZonedDateTime?,
        val pledged: BigDecimal?,
        val budgetReached: BigDecimal,
        val tags: List<CauseTypeResponseVo>
) {
    constructor(entity: Cause) : this(
            id = entity.id!!,
            name = entity.name,
            description = entity.description,
            createdAt = entity.createdAt,
            deadline = entity.deadline,
            pledged = entity.pledged,
            budgetReached = entity.budgetReached ?: BigDecimal.ZERO,
            tags = entity.causeTypes.toCauseTypeVoList()
    )
}

data class CauseTypeResponseVo(
        val id: Long,
        val name: String
)

internal fun List<CauseType>.toCauseTypeVoList() =
        map { CauseTypeResponseVo(id = it.id!!, name = it.name) }

internal fun MutableList<Cause>.toCauseResponseVoList() =
        map { CauseResponseVo(it) }

internal fun List<String>.toCauseTypes() =
        map { CauseType(id = null, name = it) }

internal fun CauseRequestVo.toCause() = Cause(
        name = this.name,
        description = this.description,
        deadline = this.deadline,
        pledged = this.pledged,
        causeTypes = this.tags.toCauseTypes()
)

