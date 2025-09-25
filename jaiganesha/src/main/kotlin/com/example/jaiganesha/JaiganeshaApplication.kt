
package com.example.jaiganesha

import com.example.jaiganesha.model.Book
import com.example.jaiganesha.repo.BookRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean

@SpringBootApplication
class JaiganeshaApplication {
    @Bean
    fun initData(bookRepository: BookRepository) = CommandLineRunner {
        bookRepository.saveAll(
            listOf(
                Book(title = "Kotlin for Beginners", author = "Alice"),
                Book(title = "Spring Boot Tips", author = "Bob")
            )
        )
    }
}

fun main(args: Array<String>) {
    runApplication<JaiganeshaApplication>(*args)
}
