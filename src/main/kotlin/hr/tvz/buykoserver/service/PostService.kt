package hr.tvz.buykoserver.service

import hr.tvz.buykoserver.hibernate.Import.SQLQuerry
import hr.tvz.buykoserver.hibernate.Import
import hr.tvz.buykoserver.model.Post
import hr.tvz.buykoserver.repositories.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PostService {

    @Autowired
    lateinit var postRepository: PostRepository

    @SQLQuerry("")
    fun getAllPosts(): List<Post> {
        return postRepository.findAll()
    }

    fun getPostById(id: Long): Post? {
        return postRepository.findByIdOrNull(id)
    }

    fun deletePostById(id: Long) {
        postRepository.deleteById(id)
    }

    fun savePost(post: Post): Post {
        return postRepository.save(post)
    }

    fun updatePost(id: Long, post: Post) {
        var foundPost = postRepository.findByIdOrNull(id)
        if (foundPost != null) {
            foundPost.title = post.title
            foundPost.category = post.category
            foundPost.description = post.description
            foundPost.price = post.price
            postRepository.save(foundPost)
        }
    }
}