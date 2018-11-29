package ong.valinor.trapis.entrypoint.vo

import ong.valinor.trapis.dataprovider.domain.Cause
import ong.valinor.trapis.dataprovider.domain.CauseType
import java.time.ZonedDateTime

data class CauseRequestVo(
        val cause: String,
        val description: String,
        val type: String
)

data class CauseResponseVo(
        val causeId: Long,
        val cause: String,
        val description: String,
        val createdAt: ZonedDateTime,
        val causeTypeResponseVo: CauseTypeResponseVo
) {
    constructor(entity: Cause) : this(
            causeId = entity.causeId!!,
            cause = entity.name,
            description = entity.description,
            createdAt = entity.createdAt,
            causeTypeResponseVo = CauseTypeResponseVo(entity.causeType))
}

data class CauseTypeRequestVo(
        val causeType: String
)

data class CauseTypeResponseVo(
        val causeTypeId: Long,
        val causeType: String
) {
    constructor(entity: CauseType) : this(
            causeTypeId = entity.causeTypeId!!,
            causeType = entity.name
    )
}

internal fun MutableList<Cause>.toCauseResponseVoList() = iterator().forEach { CauseResponseVo(it) }

internal fun CauseRequestVo.toCause() = Cause(
        name = this.cause,
        description = this.description,
        causeType = CauseType(name = this.type)
)

internal fun CauseTypeRequestVo.toCauseType() = CauseType(
        name = this.causeType
)
