package hr.tvz.buykoserver.controllers

import hr.tvz.buykoserver.model.User
import hr.tvz.buykoserver.repositories.UserRepositroy
import hr.tvz.buykoserver.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
class UserController (
        ) {

    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun getAllUser(): List<User> {
        return userService.getAllUsers()
    }



}