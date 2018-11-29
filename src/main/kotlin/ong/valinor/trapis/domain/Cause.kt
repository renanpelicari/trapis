package ong.valinor.trapis.domain

import java.time.ZonedDateTime

data class Cause(
        val cause: String,
        val description: String,
        val createdAt: ZonedDateTime,
        val causeType: CauseType
)

data class CauseType(
        val causeType: String
)
