package person.mapper

import core.mapper.Mapper
import person.domain.Person
import user.domain.User


class PersonToUserMapper : Mapper<Person, User> {

    override fun map(person: Person): User =
        User(
            id = person.id,
            externalUuid = person.externalUuid,
        )
}