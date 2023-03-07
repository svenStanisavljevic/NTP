package hr.tvz.buykoserver.controllers

import hr.tvz.buykoserver.model.Post
import hr.tvz.buykoserver.model.PostUser
import hr.tvz.buykoserver.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("posts")
class PostController {

    @Autowired
    lateinit var postService: PostService

    @GetMapping
    fun getAllPost(): List<Post> {
        return postService.getAllPosts()
    }

    @GetMapping("/all")
    fun get(): List<PostUser> {
        return postService.get()
    }
}