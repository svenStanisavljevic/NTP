package hr.tvz.buykoserver.service

import hr.tvz.buykoserver.model.User
import hr.tvz.buykoserver.repositories.UserRepositroy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepositroy: UserRepositroy

    fun save(user: User): User {
        return userRepositroy.save(user)
    }

    fun getAllUsers(): List<User> {
        return userRepositroy.findAll()
    }

}