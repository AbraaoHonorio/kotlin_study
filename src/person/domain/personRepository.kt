package person.domain

import java.util.UUID

interface PersonRepository {
    fun findById(id: Long): Person
    fun findByExternalId(externalId: UUID): Person?
}