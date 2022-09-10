package com.example.pdi2.infra.command.events

import com.example.pdi2.domain.entity.User
import com.example.pdi2.infra.command.command.CreateUserCommand
import org.axonframework.modelling.command.AggregateIdentifier
import java.util.*

class UserCreatedEvent(
    @AggregateIdentifier val id: UUID,
    val name: String,
    val email: String,
)

fun CreateUserCommand.toUserCreatedEvent() = UserCreatedEvent(
    id = id,
    name = name,
    email = email,
)

fun UserCreatedEvent.toEntity() = User(
    id = id,
    name = name,
    email = email,
)
