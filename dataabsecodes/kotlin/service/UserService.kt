package com.example.databasecode.service


import com.example.databasecode.model.User
import com.example.databasecode.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> = userRepository.findAll()

    fun getUserById(id: Long): User? = userRepository.findById(id).orElse(null)

    fun addUser(user: User): User = userRepository.save(user)
}
