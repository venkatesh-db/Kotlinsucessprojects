
package com.example.jaiganesha.model

import jakarta.persistence.*

@Entity
data class Book(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    var title: String = "",
    var author: String = ""
)
