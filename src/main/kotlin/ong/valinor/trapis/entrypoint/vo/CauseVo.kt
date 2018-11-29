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
        val type: CauseTypeRequestVo
)

data class CauseResponseVo(
        val id: Long,
        val name: String,
        val description: String,
        val createdAt: ZonedDateTime,
        val deadline: ZonedDateTime?,
        val pledged: BigDecimal?,
        val budgetReached: BigDecimal,
        val causeType: CauseTypeResponseVo
) {
    constructor(entity: Cause) : this(
            id = entity.id!!,
            name = entity.name,
            description = entity.description,
            createdAt = entity.createdAt,
            deadline = entity.deadline,
            pledged = entity.pledged,
            budgetReached = entity.budgetReached ?: BigDecimal.ZERO,
            causeType = CauseTypeResponseVo(entity.causeType))
}

data class CauseTypeRequestVo(
        val id: Long?,
        val name: String
)

data class CauseTypeResponseVo(
        val id: Long,
        val name: String
) {
    constructor(entity: CauseType) : this(
            id = entity.id!!,
            name = entity.name
    )
}

internal fun MutableList<Cause>.toCauseResponseVoList() =
        map { CauseResponseVo(it) }

internal fun CauseRequestVo.toCause() = Cause(
        name = this.name,
        description = this.description,
        deadline = this.deadline,
        pledged = this.pledged,
        causeType = CauseType(
                id = this.type.id,
                name = this.type.name
        )
)

internal fun CauseTypeRequestVo.toCauseType() = CauseType(
        id = this.id,
        name = this.name
)
