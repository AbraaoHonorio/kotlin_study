package user.domain

import java.util.UUID

data class User(
    var id: Long,
    val externalUuid: UUID,
    val email: String? = null,
)