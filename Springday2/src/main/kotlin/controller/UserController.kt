
package com.example.springday2.controller

import com.example.springday2.model.User
import com.example.springday2.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) { // DI via constructor

    @GetMapping
    fun getUsers(): List<User> = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Int): User? = userService.getUserById(id)

    @PostMapping
    fun addUser(@RequestBody user: User): User {
        // just return the user for demo; normally you'd save to DB
        return user
    }
}

