package hr.tvz.buykoserver.service

import hr.tvz.buykoserver.model.Post
import hr.tvz.buykoserver.model.PostUser
import hr.tvz.buykoserver.repositories.PostRepository
import hr.tvz.buykoserver.repositories.PostUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService {

    @Autowired
    lateinit var postRepository: PostRepository

    @Autowired
    lateinit var userPostRepository: PostUserRepository

    fun getAllPosts(): List<Post> {
        return postRepository.findAll()
    }

    fun get(): List<PostUser> {
        return userPostRepository.findAll()
    }

}