package hr.tvz.buykoserver.controllers

import hr.tvz.buykoserver.model.Post
import hr.tvz.buykoserver.security.PasswordUtil
import hr.tvz.buykoserver.service.PostService
import hr.tvz.buykoserver.service.UserService
import org.hibernate.SQLQuery
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("posts")
class PostController {

    @Autowired
    lateinit var postService: PostService

    @Autowired
    lateinit var userService: UserService

    val passwordUtil = PasswordUtil()

    @GetMapping
    fun getAllPost(
        @RequestHeader("username") username: String,
        @RequestHeader("password") password: String
    ): ResponseEntity<List<Post>> {
        return if (authoriseUser(username, password, listOf(1, 2))) {
            val posts = postService.getAllPosts()
            ResponseEntity.ok(posts)
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    @GetMapping(value = ["/{id}"])
    fun getPostById(
        @PathVariable id: Long,
        @RequestHeader("username") username: String,
        @RequestHeader("password") password: String
    ): ResponseEntity<Post?> {
        return if (authoriseUser(username, password, listOf(1, 2))) {
            val post = postService.getPostById(id)
            ResponseEntity.ok(post)
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    @DeleteMapping(value = ["/{id}"])
    fun deletePostById(
        @PathVariable id: Long,
        @RequestHeader("username") username: String,
        @RequestHeader("password") password: String
    ): ResponseEntity<Post> {
        return if (authoriseUser(username, password, listOf(2))) {
            postService.deletePostById(id)
            ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    @PostMapping(consumes = ["application/json"], produces = ["application/json"])
    fun createPost(
        @RequestBody post: Post,
        @RequestHeader("username") username: String,
        @RequestHeader("password") password: String
    ): ResponseEntity<Post> {
        return if (authoriseUser(username, password, listOf(1, 2))) {
            post.user = userService.getUserById(post.user.id)!!
            postService.savePost(post)
            ResponseEntity.status(HttpStatus.CREATED).build()
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }

    }

    @PutMapping(consumes = ["application/json"], produces = ["application/json"], value = ["/{id}"])
    fun updatePost(
        @PathVariable id: Long,
        @RequestBody post: Post,
        @RequestHeader("username") username: String,
        @RequestHeader("password") password: String
    ): ResponseEntity<Post> {
        return if (authoriseUser(username, password, listOf(2))) {
            postService.updatePost(id, post)
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