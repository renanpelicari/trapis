package ong.valinor.trapis.entrypoint.vo

import ong.valinor.trapis.dataprovider.entity.CauseEntity
import ong.valinor.trapis.dataprovider.entity.CauseTypeEntity
import java.time.ZonedDateTime

data class CauseVo(
        val cause: String,
        val description: String,
        val createdAt: ZonedDateTime,
        val causeTypeVo: CauseTypeVo
)

data class CauseResponseVo(
        val causeId: Long,
        val cause: String,
        val description: String,
        val createdAt: ZonedDateTime,
        val causeTypeResponseVo: CauseTypeResponseVo
) {
    constructor(entity: CauseEntity) : this(
            causeId = entity.causeId!!,
            cause = entity.cause,
            description = entity.description,
            createdAt = entity.createdAt,
            causeTypeResponseVo = CauseTypeResponseVo(entity.causeTypeEntity))
}

data class CauseTypeVo(
        val causeType: String
)

data class CauseTypeResponseVo(
        val causeTypeId: Long,
        val causeType: String
) {
    constructor(entity: CauseTypeEntity) : this(
            causeTypeId = entity.causeTypeId,
            causeType = entity.causeType
    )
}

internal fun MutableList<CauseEntity>.toCauseResponseVoList() = iterator().forEach { CauseResponseVo(it) }
