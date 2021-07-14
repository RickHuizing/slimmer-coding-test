package rjhuizing.slimmer.coding.test.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rjhuizing.slimmer.coding.test.model.entities.MemberShip
import rjhuizing.slimmer.coding.test.repository.CustomerRepository
import rjhuizing.slimmer.coding.test.repository.MemberShipRepository
import rjhuizing.slimmer.coding.test.repository.MemberShipTypeRepository

/**
 * used to register new memberships to customers.
 * //todo split controllers and repositories using services
 */
@RestController
@RequestMapping("/memberships")
class MemberShipController(
    var customerRepository: CustomerRepository,
    var memberShipRepository: MemberShipRepository,
    var memberShipTypeRepository: MemberShipTypeRepository
) {

    @PostMapping("/register")
    fun registerMembership(@RequestBody memberShipDTO: MemberShipDTO): MemberShip? {
        val customer = customerRepository.findById(memberShipDTO.customer_id)
        val memberShipType = memberShipTypeRepository.findById(memberShipDTO.member_ship_type_id)
        return memberShipRepository.save(
            MemberShip(
                null,
                customer.get(),
                memberShipType.get(),
                true
            )
        )
    }

    data class MemberShipDTO(
        var id: Long,
        var customer_id: Long,
        var member_ship_type_id: String,
        var isActive: Boolean
    )
}
