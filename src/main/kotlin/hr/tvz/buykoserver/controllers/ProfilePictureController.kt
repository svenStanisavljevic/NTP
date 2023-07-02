package hr.tvz.buykoserver.controllers

import com.google.gson.Gson
import com.google.gson.JsonObject
import hr.tvz.buykoserver.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("upload")
class ProfilePictureController {

    @Autowired
    lateinit var userService: UserService

    @PostMapping
    fun uploadPhoto (
        @RequestBody profilePicture: String,
        @RequestHeader username: String,
        @RequestHeader password: String
    ): ResponseEntity<Int> {
        val gson = Gson()
        val jsonObject = gson.fromJson<JsonObject>(profilePicture, JsonObject::class.java)
        val selectedUser = userService.getUserByUsername(username)
        selectedUser.profilePicture = jsonObject.get("picture").asString
        userService.saveUser(selectedUser)
        return ResponseEntity.ok(0)
    }


}