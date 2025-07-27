package com.bramwork.users

import jakarta.validation.Validator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.web.servlet.function.RequestPredicates
import org.springframework.web.servlet.function.RouterFunction
import org.springframework.web.servlet.function.RouterFunctions
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse

@Configuration
class UsersRoutes {
    @Bean
    fun userRoutes(usersHandler: UsersHandler): RouterFunction<ServerResponse> {
        return RouterFunctions.route().nest(RequestPredicates.path("/users")) { builder: RouterFunctions.Builder ->
            builder.GET(
                "",
                RequestPredicates.accept(MediaType.APPLICATION_JSON)
            ) { request: ServerRequest -> usersHandler.findAll(request) }
            builder.GET(
                "/{email}",
                RequestPredicates.accept(MediaType.APPLICATION_JSON)
            ) { request: ServerRequest -> usersHandler.findUserByEmail(request) }
            builder.POST("") { request: ServerRequest -> usersHandler.save(request) }
            builder.DELETE("/{email}") { request: ServerRequest -> usersHandler.deleteByEmail(request) }
        }.build()
    }

    @Bean
    fun validator(): Validator = LocalValidatorFactoryBean()
}