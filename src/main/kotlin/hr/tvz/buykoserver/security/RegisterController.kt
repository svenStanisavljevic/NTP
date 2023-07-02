package hr.tvz.buykoserver.security

import hr.tvz.buykoserver.model.User
import hr.tvz.buykoserver.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("register")
class RegisterController {

    @Autowired
    lateinit var userService: UserService

    val passwordUtil = PasswordUtil()

    @PostMapping(consumes = ["application/json"], produces = ["application/json"])
    fun register(
        @RequestBody user: User
    ): ResponseEntity<User> {
        user.creationTS = System.currentTimeMillis().toString()
        user.password = passwordUtil.seededSHA(user.password, user.creationTS)
        userService.saveUser(user)
        return ResponseEntity.ok(user)
    }

}