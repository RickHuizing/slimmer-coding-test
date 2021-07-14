package rjhuizing.slimmer.coding.test.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rjhuizing.slimmer.coding.test.model.entities.Vehicle
import rjhuizing.slimmer.coding.test.repository.VehicleRepository
import rjhuizing.slimmer.coding.test.repository.VehicleTypeRepository

@RestController
@RequestMapping("/test")
class TestController(
    val vehicleRepository: VehicleRepository,
    val vehicleTypeRepository: VehicleTypeRepository
) {

    @PostMapping("/initializeVehicles")
    fun initializeVehicles() {
        vehicleTypeRepository.findAll().forEach {
            if (it != null) {
                var vehicle = Vehicle(null, it, "${it.id}1", false, null)
                vehicleRepository.save(vehicle)
                vehicle = Vehicle(null, it, "${it.id}2", false, null)
                vehicleRepository.save(vehicle)
            }
        }
        vehicleRepository.findAll().forEach { print("${it?.id} ") }
    }
}