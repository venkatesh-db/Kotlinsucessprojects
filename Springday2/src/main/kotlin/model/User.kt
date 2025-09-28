

package com.example.springday2.model

import com.fasterxml.jackson.annotation.JsonProperty

data class User(
    val id: Int,
    val name: String,
    val email: String,
    @JsonProperty("is_active") val isActive: Boolean
)
