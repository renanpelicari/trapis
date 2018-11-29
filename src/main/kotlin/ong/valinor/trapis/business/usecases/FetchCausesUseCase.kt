package ong.valinor.trapis.business.usecases

import ong.valinor.trapis.dataprovider.entity.CauseEntity

interface FetchCausesUseCase {

    /**
     * Fetch a list of all registered causes.
     *
     * @return the {@link CauseResponseVo} list.
     */
    fun execute(): MutableList<CauseEntity>
}
