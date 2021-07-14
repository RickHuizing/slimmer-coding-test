package rjhuizing.slimmer.coding.test.controller

import org.springframework.web.bind.annotation.*
import rjhuizing.slimmer.coding.test.model.entities.VehicleSuperType
import rjhuizing.slimmer.coding.test.repository.*

@RestController
@RequestMapping("/vehicle_super_types")
class VehicleSuperTypeController(
    var vehicleSuperTypeRepository: VehicleSuperTypeRepository
) {

    /**
     * Get vehicleSuperTypes as JSON instead of default HAL
     */
    @GetMapping("/extended")
    fun base(): MutableIterable<VehicleSuperType?> {
        return vehicleSuperTypeRepository.findAll()
    }
}
