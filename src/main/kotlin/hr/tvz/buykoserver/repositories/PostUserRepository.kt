package hr.tvz.buykoserver.repositories

import hr.tvz.buykoserver.model.PostUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostUserRepository: JpaRepository<PostUser, Long> {
}