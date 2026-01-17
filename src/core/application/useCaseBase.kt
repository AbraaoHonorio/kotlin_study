package core.application

import core.domain.UserIdentifier

abstract class UseCaseBase<I : Any> {

    fun <O : Any> execute(input: UserIdentifier, mapper: (I) -> O): O {
        val domain = resolve(input)
        return mapper(domain)
    }

    protected abstract fun resolve(input: UserIdentifier): I
}