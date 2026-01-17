package core.domain

import java.util.UUID

sealed interface UserIdentifier {

    @JvmInline
    value class InternalId(val value: Long) : UserIdentifier

    @JvmInline
    value class ExternalUuid(val value: UUID) : UserIdentifier
}