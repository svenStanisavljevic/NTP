package hr.tvz.buykoserver.controllers

import hr.tvz.buykoserver.model.User
import hr.tvz.buykoserver.security.PasswordUtil
import hr.tvz.buykoserver.service.LocationService
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
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
class UserController () {

    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var locationService: LocationService

    val passwordUtil = PasswordUtil()

    @GetMapping
    fun getAllUser(
        @RequestHeader("username") username: String,
        @RequestHeader("password") password: String
    ): ResponseEntity<List<User>> {
        return if (authoriseUser(username, password, listOf(1, 2))) {
            val users = userService.getAllUsers()
            ResponseEntity.ok(users)
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    @GetMapping(value = arrayOf("/{id}"))
    fun getUserById(
        @PathVariable id: Long,
        @RequestHeader("username") username: String,
        @RequestHeader("password") password: String
    ): ResponseEntity<User?> {
        return if (authoriseUser(username, password, listOf(1, 2))) {
            val user = userService.getUserById(id)!!
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    @DeleteMapping(value = arrayOf("/{id}"))
    fun deleteUserById(
        @PathVariable id: Long,
        @RequestHeader("username") username: String,
        @RequestHeader("password") password: String
    ): ResponseEntity<User> {
        return if (authoriseUser(username, password, listOf(2))) {
            userService.deleteUserById(id)
            ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    @PostMapping(consumes = ["application/json"], produces = ["application/json"])
    fun createUser(
        @RequestBody user: User,
        @RequestHeader("username") username: String,
        @RequestHeader("password") password: String
    ): ResponseEntity<User> {
        return if (authoriseUser(username, password, listOf(2))) {
            user.location = locationService.getLocationById(user.location!!.id)!!
            userService.saveUser(user)
            ResponseEntity.status(HttpStatus.CREATED).build()
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    @PutMapping(consumes = arrayOf("application/json"), produces = arrayOf("application/json"), value = arrayOf("/{id}"))
    fun updateUser(
        @PathVariable id: Long,
        @RequestBody user: User,
        @RequestHeader("username") username: String,
        @RequestHeader("password") password: String
    ): ResponseEntity<User> {
        return if (authoriseUser(username, password, listOf(2))) {
            userService.updateUser(id, user)
            ResponseEntity.status(HttpStatus.OK).build()
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    private fun authoriseUser(username:String, password: String, permittedRoles: List<Int>): Boolean {
        val user = userService.getUserByUsername(username)
        if (passwordUtil.isPasswordMatch(user.password, password, user.creationTS)) {
            if (permittedRoles.contains(user.role)) {
                return true
            }
        }
        return false
    }

}