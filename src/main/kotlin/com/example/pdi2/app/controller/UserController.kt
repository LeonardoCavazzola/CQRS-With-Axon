package com.example.pdi2.app.controller

import com.example.pdi2.app.controller.input.UserInput
import com.example.pdi2.app.controller.input.toCreateUserCommand
import com.example.pdi2.app.controller.output.UserOutput
import com.example.pdi2.app.controller.output.toOutput
import com.example.pdi2.domain.entity.User
import com.example.pdi2.infra.query.query.GetUsersQuery
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.messaging.responsetypes.ResponseTypes
import org.axonframework.queryhandling.QueryGateway
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/users")
class UserController(
    private val commandGateway: CommandGateway,
    private val queryGateway: QueryGateway,
) {
    @GetMapping
    fun findAll(): List<UserOutput> =
        queryGateway.query(GetUsersQuery(), ResponseTypes.multipleInstancesOf(User::class.java))
            .join()
            .map { it.toOutput() }

    @PostMapping
    fun create(@RequestBody input: UserInput): UserOutput {
        val command = input.toCreateUserCommand()
        commandGateway.sendAndWait<UUID>(command)
        return command.toOutput()
    }
}
