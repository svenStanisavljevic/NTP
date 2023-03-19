package hr.tvz.buykoserver.controllers

import hr.tvz.buykoserver.model.User
import hr.tvz.buykoserver.repositories.UserRepositroy
import hr.tvz.buykoserver.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @GetMapping(value = arrayOf("/{id}"))
    fun getUserById(@PathVariable id: Long): User? {
        return userService.getUserById(id)
    }

    @DeleteMapping(value = arrayOf("/{id}"))
    fun deleteUserById(@PathVariable id: Long) {
        userService.deleteUserById(id)
    }

    @PostMapping(consumes = arrayOf("application/json"), produces = arrayOf("application/json"))
    fun createUser(@RequestBody user: User) {
        userService.saveUser(user)
    }

    @PutMapping(consumes = arrayOf("application/json"), produces = arrayOf("application/json"), value = arrayOf("/{id}"))
    fun updateUser(@PathVariable id: Long, @RequestBody user: User) {
        userService.updateUser(id, user)
    }


}