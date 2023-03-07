package hr.tvz.buykoserver

import hr.tvz.buykoserver.repositories.UserRepositroy
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

//TODO: remove excluded annotations when doing DB/Security
@SpringBootApplication(exclude = [SecurityAutoConfiguration::class, QuartzAutoConfiguration::class])
@EnableJpaRepositories(basePackageClasses = [UserRepositroy::class])
class BuykoServerApplication

fun main(args: Array<String>) {
    runApplication<BuykoServerApplication>(*args)
}
