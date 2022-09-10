package com.example.pdi2.app.controller.input

import com.example.pdi2.infra.command.command.CreateUserCommand
import java.util.*

class UserInput(
    val name: String,
    val email: String,
)

fun UserInput.toCreateUserCommand() = CreateUserCommand(
    id = UUID.randomUUID(),
    name = name,
    email = email,
)
