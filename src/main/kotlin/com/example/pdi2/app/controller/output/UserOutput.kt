package com.example.pdi2.app.controller.output

import com.example.pdi2.domain.entity.User
import com.example.pdi2.infra.command.command.CreateUserCommand
import java.util.UUID

class UserOutput(
    val id: UUID,
    val name: String,
    val email: String,
)

fun User.toOutput() = UserOutput(
    id = id,
    name = name,
    email = email,
)

fun CreateUserCommand.toOutput() = UserOutput(
    id = id,
    name = name,
    email = email,
)
