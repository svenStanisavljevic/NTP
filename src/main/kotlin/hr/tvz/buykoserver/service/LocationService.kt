package hr.tvz.buykoserver.service

import hr.tvz.buykoserver.model.Location
import hr.tvz.buykoserver.repositories.LocationRepository
import hr.tvz.buykoserver.repositories.UserRepositroy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class LocationService {

    @Autowired
    lateinit var locationRepository: LocationRepository

    @Autowired
    lateinit var userRepositroy: UserRepositroy

    fun getAllLocations(): List<Location> {
        return locationRepository.findAll()
    }

    fun getLocationById(id: Long): Location? {
        return locationRepository.findByIdOrNull(id)
    }

    fun getLocationsByCountry(country: String): List<Location> {
        return locationRepository.findLocationsByCountry(country)
    }

    fun getLocationsByRegion(region: String): List<Location> {
        return locationRepository.findLocationsByRegion(region)
    }

    fun getLocationByCity(city: String): Location {
        return locationRepository.findLocationByCity(city)
    }

    fun deleteLocationById(id: Long) {
        userRepositroy.findAll().forEach {
            if (it.location!!.id == id) {
                it.location = null
            }
        }
        locationRepository.deleteById(id)
    }

    fun saveLocation(location: Location): Location {
        return locationRepository.save(location)
    }

    fun updateLocation(id: Long, location: Location) {
        var foundLocation = locationRepository.findByIdOrNull(id)
        if (foundLocation != null) {
            foundLocation.country = location.country
            foundLocation.region = location.region
            foundLocation.city = location.city
            locationRepository.save(foundLocation)
        }
    }

}
