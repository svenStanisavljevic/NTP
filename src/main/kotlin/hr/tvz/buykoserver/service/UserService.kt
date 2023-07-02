package hr.tvz.buykoserver.service

import hr.tvz.buykoserver.model.User
import hr.tvz.buykoserver.repositories.UserRepositroy
import hr.tvz.buykoserver.security.PasswordUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepositroy: UserRepositroy

    fun getAllUsers(): List<User> {
        return userRepositroy.findAll()
    }

    fun getUserById(id: Long): User? {
        return userRepositroy.findByIdOrNull(id)
    }

    fun getUserByUsername(username:String): User {
        return userRepositroy.findUserByUsername(username)
    }

    fun deleteUserById(id: Long) {
        userRepositroy.deleteById(id)
    }

    fun saveUser(user: User): User {
        return userRepositroy.save(user)
    }

    fun updateUser(id: Long, user: User) {
        val foundUser = userRepositroy.findByIdOrNull(id)
        if (foundUser != null) {
            foundUser.username = user.username
            foundUser.firstName = user.firstName
            foundUser.lastName = user.lastName
            foundUser.email = user.email
            foundUser.password = user.password
            foundUser.phoneNumber = user.phoneNumber
            foundUser.location = user.location
            userRepositroy.save(foundUser)
        }

    }

}