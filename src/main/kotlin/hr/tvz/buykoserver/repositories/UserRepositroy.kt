package hr.tvz.buykoserver.repositories

import hr.tvz.buykoserver.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepositroy : JpaRepository<User, Long> {

    fun findUserByUsername(username: String): User

}