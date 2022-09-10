package com.example.pdi2.infra.command.command

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.UUID

class CreateUserCommand(
    @TargetAggregateIdentifier val id: UUID,
    val name: String,
    val email: String,
)
