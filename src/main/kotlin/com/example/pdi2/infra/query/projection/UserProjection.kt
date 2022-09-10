package com.example.pdi2.infra.query.projection

import com.example.pdi2.domain.entity.User
import com.example.pdi2.infra.query.query.GetUsersQuery
import com.example.pdi2.infra.repository.UserRepository
import org.axonframework.queryhandling.QueryHandler
import org.springframework.stereotype.Component

@Component
class UserProjection(
    private val userRepository: UserRepository,
) {
    @QueryHandler
    fun handleQuery(getUsersQuery: GetUsersQuery): List<User> {
        return userRepository.findAll()
    }
}
