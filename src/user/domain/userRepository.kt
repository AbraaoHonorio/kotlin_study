package user.domain

import java.util.UUID


interface UserRepository {
    fun findById(id: Long): User
    fun findByExternalId(externalId: UUID): User?
}