package ong.valinor.trapis.entrypoint.rest

import ong.valinor.trapis.business.usecases.FetchCausesUseCase
import ong.valinor.trapis.entrypoint.vo.toCauseResponseVoList
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CausesController(val fetchCausesUseCase: FetchCausesUseCase) {

    /**
     * Fetch all causes registered.
     */
    @GetMapping
    fun fetchAllCauses() =
            fetchCausesUseCase.execute().toCauseResponseVoList()
}
