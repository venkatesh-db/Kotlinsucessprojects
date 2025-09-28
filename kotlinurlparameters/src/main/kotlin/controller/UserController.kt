package com.example.kotlinurlparameters.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController {

    // 👉 Example 1: Path Parameter (/api/users/101)
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Int): String {
        return "User with ID: $id"
    }

    // 👉 Example 2: Query Parameter (/api/users?active=true&role=admin)
    @GetMapping
    fun getUsers(
        @RequestParam(required = false, defaultValue = "false") active: Boolean,
        @RequestParam(required = false) role: String?
    ): String {
        return "Users with active=$active, role=$role"
    }

    // 👉 Example 3: Multiple Params (/api/users/filter?age=25&country=India)
    @GetMapping("/filter")
    fun filterUsers(
        @RequestParam age: Int,
        @RequestParam country: String
    ): String {
        return "Filter users by age=$age, country=$country"
    }
}
