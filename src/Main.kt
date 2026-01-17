import core.domain.UserIdentifier
import person.application.FindPersonUseCase
import person.domain.Person
import person.mapper.PersonToUserMapper
import person.port.InMemoryPersonRepository
import user.application.FindUserUseCase
import user.domain.User
import user.mapper.UserToPersonMapper
import user.port.InMemoryUserRepository
import java.util.UUID


fun main() {
    val user = User(
        id = 1L,
        externalUuid = UUID.randomUUID(),
        email = "abraaohonoriopb@gmail.com"
    )
    val userOne = User(
        id = 2L,
        externalUuid = UUID.randomUUID(),
        email = "abraaohonoriopb2@gmail.com"
    )

    val userRepository = InMemoryUserRepository(listOf(user, userOne))

    val person = Person(
        id = 10L,
        externalUuid = user.externalUuid,
        name = "Abraão"
    )
    val personOne = Person(
        id = 10L,
        externalUuid = userOne.externalUuid,
        name = "Honório"
    )
    val personRepository = InMemoryPersonRepository(listOf(person, personOne))


    val findUserUseCase = FindUserUseCase(userRepository)

    val userResult: User = findUserUseCase.execute(
        UserIdentifier.ExternalUuid(person.externalUuid)
    ) { it }

    println("$userResult, ${userResult == user}")

    val personFromUser: Person =
        findUserUseCase.execute(UserIdentifier.InternalId(user.id))
        { person ->
            UserToPersonMapper().map(person)
        }

    println("$personFromUser, ${personFromUser.externalUuid == person.externalUuid}")


    // PERSON
    val findPersonUseCase = FindPersonUseCase(personRepository)


    val personResult: Person = findPersonUseCase.execute(
        UserIdentifier.ExternalUuid(user.externalUuid)
    ) { it }
    println("$personResult, ${personResult == person}")

    val userFromPerson: User = findPersonUseCase.execute(
        UserIdentifier.ExternalUuid(person.externalUuid)
    )
    { person ->
        PersonToUserMapper().map(person)
    }

    println("$userFromPerson, ${userFromPerson.externalUuid == user.externalUuid}")
}