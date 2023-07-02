package hr.tvz.buykoserver

import hr.tvz.buykoserver.repositories.LocationRepository
import hr.tvz.buykoserver.repositories.PostRepository
import hr.tvz.buykoserver.repositories.UserRepositroy
import org.springframework.boot.autoconfigure.SpringBootApplication

import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = [UserRepositroy::class, PostRepository::class, LocationRepository::class])
class BuykoServerApplication

fun main(args: Array<String>) {
    runApplication<BuykoServerApplication>(*args)
}
