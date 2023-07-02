package hr.tvz.buykoserver.controllers

import hr.tvz.buykoserver.model.Location
import hr.tvz.buykoserver.model.Post
import hr.tvz.buykoserver.security.PasswordUtil
import hr.tvz.buykoserver.service.LocationService
import hr.tvz.buykoserver.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("locations")
class LocationController {

    @Autowired
    lateinit var locationService: LocationService

    @Autowired
    lateinit var userService: UserService

    val passwordUtil = PasswordUtil()

    @GetMapping
    fun getAllLocation(): ResponseEntity<List<Location>> {
        val locations = locationService.getAllLocations()
        return ResponseEntity.ok(locations)
    }

    @GetMapping(value = ["/{id}"])
    fun getLocationById(@PathVariable id: Long,
        @RequestHeader("username") username: String,
        @RequestHeader("password") password: String
    ): ResponseEntity<Location?> {
        return if (authoriseUser(username, password, listOf(1, 2))) {
            val location = locationService.getLocationById(id)
            ResponseEntity.ok(location)
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    @GetMapping(value = ["/country/{country}"])
    fun getLocationsByCountry(@PathVariable country: String): List<Location> {
        return locationService.getLocationsByCountry(country)
    }

    @GetMapping(value = ["/region/{region}"])
    fun getLocationsByRegion(@PathVariable region: String): List<Location> {
        return locationService.getLocationsByRegion(region)
    }

    @GetMapping(value = ["/city/{city}"])
    fun getLocationByCity(@PathVariable city: String): Location {
        return locationService.getLocationByCity(city)
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteLocationById(@PathVariable id: Long,
                           @RequestHeader("username") username: String,
                           @RequestHeader("password") password: String
    ): ResponseEntity<Location> {
        return if (authoriseUser(username, password, listOf(2))) {
            locationService.deleteLocationById(id)
            ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }

    }

    @PostMapping(consumes = ["application/json"], produces = ["application/json"])
    fun createLocation(@RequestBody location: Location,
                       @RequestHeader("username") username: String,
                       @RequestHeader("password") password: String
    ): ResponseEntity<Location> {
        return if (authoriseUser(username, password, listOf(2))) {
            locationService.saveLocation(location)
            ResponseEntity.status(HttpStatus.CREATED).build()
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }

    }

    @PutMapping(consumes = ["application/json"], produces = ["application/json"], value = ["/{id}"])
    fun updateLocation(@PathVariable id: Long,
                       @RequestBody location: Location,
                       @RequestHeader("username") username: String,
                       @RequestHeader("password") password: String
    ):ResponseEntity<Location> {
        return if (authoriseUser(username, password, listOf(2))) {
            locationService.updateLocation(id, location)
            ResponseEntity.status(HttpStatus.OK).build()
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
        locationService.updateLocation(id, location)
    }

    private fun authoriseUser(username:String, password: String, permittedRoles: List<Int>): Boolean {
        val user = userService.getUserByUsername(username)
        if (passwordUtil.isPasswordMatch(user.password, password, user.creationTS)) {
            if (permittedRoles.contains(user.role)) {
                return true
            }
        }
        return false
    }

}