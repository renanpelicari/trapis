package ong.valinor.trapis.business.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY,
        reason = "Entity could not be deleted due id was not found.")
class CouldNotDeleteEntityDueIdNotFound(entityName: String,
                                        entityId: String) :

        IllegalArgumentException("""Entity [$entityName] could not be delete due id [$entityId] was not found.""") {

    constructor(entityName: String, entityId: Long) : this(
            entityName = entityName,
            entityId = entityId.toString()
    )
}
