
package com.example.springday2.service

import com.example.springday2.model.User
import org.springframework.stereotype.Service

@Service // Spring DI will automatically inject this
class UserService {

    private val users = listOf(
        User(1, "Alice", "alice@example.com", true),
        User(2, "Bob", "bob@example.com", false)
    )

    fun getAllUsers(): List<User> = users

    fun getUserById(id: Int): User? = users.find { it.id == id }
}
