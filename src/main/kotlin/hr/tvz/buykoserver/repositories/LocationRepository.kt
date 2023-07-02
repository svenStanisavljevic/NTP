package hr.tvz.buykoserver.repositories

import hr.tvz.buykoserver.model.Location
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocationRepository : JpaRepository<Location, Long> {

    fun findLocationsByCountry(country: String): List<Location>

    fun findLocationsByRegion(region: String): List<Location>

    fun findLocationByCity(city: String): Location

}