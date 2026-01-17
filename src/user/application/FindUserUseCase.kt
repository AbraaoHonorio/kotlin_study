package user.application

import core.application.UseCaseBase
import core.domain.UserIdentifier
import user.domain.User
import user.domain.UserRepository

class FindUserUseCase(
    private val userRepository: UserRepository
) : UseCaseBase<User>() {

    override fun resolve(input: UserIdentifier): User =
        when (input) {
            is UserIdentifier.InternalId ->
                userRepository.findById(input.value)

            is UserIdentifier.ExternalUuid ->
                userRepository.findByExternalId(input.value) ?: error("User not found for $input")
        }

}


