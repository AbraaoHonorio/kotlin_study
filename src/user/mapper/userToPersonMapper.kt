package user.mapper

import core.mapper.Mapper
import person.domain.Person
import user.domain.User


class UserToPersonMapper : Mapper<User, Person> {

    override fun map(user: User): Person =
        Person(
            id = user.id,
            externalUuid = user.externalUuid,
        )
}
