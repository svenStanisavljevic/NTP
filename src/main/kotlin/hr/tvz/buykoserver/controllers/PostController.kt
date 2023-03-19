package hr.tvz.buykoserver.controllers

import hr.tvz.buykoserver.model.Post
import hr.tvz.buykoserver.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @GetMapping(value = arrayOf("/{id}"))
    fun getPostById(@PathVariable id: Long): Post? {
        return postService.getPostById(id)
    }

    @DeleteMapping(value = arrayOf("/{id}"))
    fun deletePostById(@PathVariable id: Long) {
        postService.deletePostById(id)
    }

    @PostMapping(consumes = arrayOf("application/json"), produces = arrayOf("application/json"))
    fun createPost(@RequestBody post: Post) {
        postService.savePost(post)
    }

    @PutMapping(consumes = arrayOf("application/json"), produces = arrayOf("application/json"), value = arrayOf("/{id}"))
    fun updatePost(@PathVariable id: Long, @RequestBody post: Post) {
        postService.updatePost(id, post)
    }
}