package person.application

import core.application.UseCaseBase
import core.domain.UserIdentifier
import person.domain.Person
import person.domain.PersonRepository

class FindPersonUseCase(
    private val personRepository: PersonRepository
) : UseCaseBase<Person>() { // Only need to define the Input type

    override fun resolve(input: UserIdentifier): Person =
        when (input) {
            is UserIdentifier.InternalId ->
                personRepository.findById(input.value)

            is UserIdentifier.ExternalUuid ->
                personRepository.findByExternalId(input.value)
                    ?: error("Person not found for $input")
        }
}