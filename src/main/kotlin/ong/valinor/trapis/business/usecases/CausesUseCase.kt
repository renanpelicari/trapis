package ong.valinor.trapis.business.usecases

import ong.valinor.trapis.dataprovider.domain.Cause
import ong.valinor.trapis.dataprovider.domain.CauseType

/**
 * File containing interfaces for usescases related to Causes.
 */

/**
 * Fetch a [MutableList] of [Cause]
 */
interface FetchCausesUseCase {
    fun execute(): MutableList<Cause>
}

/**
 * Register new [Cause] based on [CauseRequestVo]
 */
interface RegisterCauseUseCase {
    fun execute(cause: Cause): Cause
}

/**
 * Find [CauseType] by [causeTypeName] or save new one
 */
interface FindOrSaveCauseTypeByNameUseCase {
    fun execute(causeTypeName: String): CauseType
}

/**
 * Delete [Cause] based on causeId.
 * @throws IllegalArgumentException when not find causeId to delete.
 */
interface DeleteCauseByIdUseCase {
    fun execute(causeId: Long)
}
