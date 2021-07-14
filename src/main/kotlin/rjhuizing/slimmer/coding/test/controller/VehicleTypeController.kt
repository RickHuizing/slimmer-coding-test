package rjhuizing.slimmer.coding.test.controller

import org.springframework.web.bind.annotation.*
import rjhuizing.slimmer.coding.test.model.entities.VehicleType
import rjhuizing.slimmer.coding.test.repository.VehicleTypeRepository

@RestController
@RequestMapping("/vehicle_types")
class VehicleTypeController(
    var vehicleTypeRepository: VehicleTypeRepository
) {

    /**
     * Get vehicleTypes as JSON instead of default HAL
     */
    @GetMapping("/")
    fun base(): MutableIterable<VehicleType?> {
        return vehicleTypeRepository.findAll()
    }

}
