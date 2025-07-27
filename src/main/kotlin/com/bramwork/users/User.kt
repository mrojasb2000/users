package com.bramwork.users

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class User(
    @get:NotBlank(message = "Email cannot be empty")
    var email: String? = null,
    @get:NotBlank(message = "Name cannot be empty")
    var name: String? = null,

    @get:Pattern(
        message = "Password must be at least 8 characters long and contain at least one number, one uppercase, one lowercase and one special character",
        regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$"
    )
    var password: String? = null,
    var gravatarUrl: String? = null,
    var userRole: List<UserRole> = mutableListOf(),
    var active: Boolean = false
)