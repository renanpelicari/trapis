package ong.valinor.trapis.entrypoint.rest

import ong.valinor.trapis.business.usecases.DeleteCauseByIdUseCase
import ong.valinor.trapis.business.usecases.FetchCausesUseCase
import ong.valinor.trapis.business.usecases.RegisterCauseUseCase
import ong.valinor.trapis.entrypoint.vo.CauseRequestVo
import ong.valinor.trapis.entrypoint.vo.toCause
import ong.valinor.trapis.entrypoint.vo.toCauseResponseVoList
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/cause"])
class CausesController(val fetchCausesUseCase: FetchCausesUseCase,
                       val registerCauseUseCase: RegisterCauseUseCase,
                       val deleteCauseByIdUseCase: DeleteCauseByIdUseCase) {

    /**
     * Fetch all causes.
     */
    @GetMapping
    fun fetchAllCauses() = fetchCausesUseCase.execute().toCauseResponseVoList()

    /**
     * Register new name based on [CauseRequestVo] and return [CauseResponseVo].
     */
    @PostMapping
    fun registerCause(@RequestBody @Validated causeRequestVo: CauseRequestVo) =
            registerCauseUseCase.execute(
                    causeRequestVo.toCause()
            )

    /**
     * Delete cause by id.
     */
    @DeleteMapping(value = ["/{causeId}"])
    fun deleteCauseById(@PathVariable @Validated causeId: Long) = deleteCauseByIdUseCase.execute(causeId)
}
