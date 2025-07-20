package com.bramwork.users

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController {
    private val users = mutableMapOf(
        "ximena@email.com" to User("ximena@email.com", "Ximena"),
        "norma@email.com" to User("norma@email.com", "Norma")
    )

    @get:GetMapping
    val all: Collection<User>
        get() = users.values

    @GetMapping("/{email}")
    fun findUserByEmail(@PathVariable email: String): User? {
        return users[email]
    }

    @PostMapping
    fun save(@RequestBody user: User): User {
        users[user.email!!] = user
        return user
    }

    @DeleteMapping("/{email}")
    fun deleteByEmail(@PathVariable email: String) {
        users.remove(email)
    }
}