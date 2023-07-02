package hr.tvz.buykoserver.security

import hr.tvz.buykoserver.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("login")
class AuthenticationController {

    @Autowired
    lateinit var userService: UserService

    val passwordUtil = PasswordUtil()

    @GetMapping
    fun authenticate(
        @RequestHeader("username") username: String,
        @RequestHeader("password") password: String
    ): ResponseEntity<Int> {
       return if (authenticateUser(username, password)) {
           ResponseEntity.status(HttpStatus.OK).build()
       }
       else {
           ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
       }
    }

    private fun authenticateUser(username:String, password: String): Boolean {
        val user = userService.getUserByUsername(username)
        return passwordUtil.isPasswordMatch(user.password, password, user.creationTS)
    }

}