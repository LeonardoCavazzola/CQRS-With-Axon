package com.example.pdi2.domain.entity

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "userr")
class User(
    @Id
    val id: UUID,
    val name: String,
    val email: String,
)
