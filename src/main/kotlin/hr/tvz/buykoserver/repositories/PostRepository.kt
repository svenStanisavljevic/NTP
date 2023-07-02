package hr.tvz.buykoserver.repositories

import hr.tvz.buykoserver.model.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: JpaRepository<Post, Long> {

}