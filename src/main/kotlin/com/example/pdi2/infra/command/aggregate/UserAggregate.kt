package com.example.pdi2.infra.command.aggregate

import com.example.pdi2.infra.command.command.CreateUserCommand
import com.example.pdi2.infra.command.events.UserCreatedEvent
import com.example.pdi2.infra.command.events.toUserCreatedEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate
import java.util.*

@Aggregate
class UserAggregate @CommandHandler constructor(
    createUserCommand: CreateUserCommand
) {
    init {
        AggregateLifecycle.apply(createUserCommand.toUserCreatedEvent())
    }

    @AggregateIdentifier
    lateinit var id: UUID
    lateinit var name: String
    lateinit var email: String

    @EventSourcingHandler
    fun on(event: UserCreatedEvent) {
        id = event.id
        name = event.name
        email = event.email
    }
}
