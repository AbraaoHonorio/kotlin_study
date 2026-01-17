package user.port

import user.domain.User
import user.domain.UserNotFoundException
import user.domain.UserRepository
import java.util.UUID

class InMemoryUserRepository(
    private val users: List<User>
) : UserRepository {

    override fun findById(id: Long): User =
        users.find { it.id == id }
            ?: throw UserNotFoundException("User not found for id=$id")

    override fun findByExternalId(externalId: UUID): User? =
        users.find { it.externalUuid == externalId }
}