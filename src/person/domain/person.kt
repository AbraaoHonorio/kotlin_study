package person.domain

import java.util.UUID

data class Person(
    val id: Long,
    val externalUuid: UUID,
    val name: String? = null,
    val uniqueIdentifier: String? = null,
)