package com.example.pdi2.infra.command.events

import com.example.pdi2.infra.repository.UserRepository
import org.axonframework.eventhandling.EventHandler
import org.springframework.stereotype.Component

@Component
class UserEventsHandler(
    private val userRepository: UserRepository,
) {
    @EventHandler
    fun on(event: UserCreatedEvent) {
        userRepository.save(event.toEntity())
    }
}
