package person.port

import person.domain.Person
import person.domain.PersonNotFoundException
import person.domain.PersonRepository
import java.util.UUID

class InMemoryPersonRepository(
    private val people: List<Person>
): PersonRepository {

    override fun findById(id: Long): Person =
        people.find { it.id == id }
            ?: throw PersonNotFoundException("Person not found for id=$id")

    override fun findByExternalId(externalId: UUID): Person? =
        people.find { it.externalUuid == externalId }
}