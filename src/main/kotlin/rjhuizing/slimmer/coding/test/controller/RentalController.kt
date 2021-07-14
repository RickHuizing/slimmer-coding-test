package rjhuizing.slimmer.coding.test.controller

import org.springframework.web.bind.annotation.*
import rjhuizing.slimmer.coding.test.model.CashMachine
import rjhuizing.slimmer.coding.test.model.entities.Payment
import rjhuizing.slimmer.coding.test.model.entities.Pledge
import rjhuizing.slimmer.coding.test.model.entities.Rental
import rjhuizing.slimmer.coding.test.model.entities.VehicleType
import rjhuizing.slimmer.coding.test.service.PaymentService
import rjhuizing.slimmer.coding.test.service.RentalService

/**
 * Handle requests pertaining to rentals.
 */
@RestController
@RequestMapping("/rentals")
class RentalController(
    var rentalService: RentalService,
    var paymentService: PaymentService
) {

    @GetMapping("/")
    fun base(): MutableIterable<VehicleType?> {
        return rentalService.getAllVehicleTypes()
    }

    @PostMapping("/rent")
    fun rent(@RequestBody rentalRequest: RentalRequest): Rental {
        return rentalService.rentVehicle(rentalRequest.vehicle_type, rentalRequest.hours, rentalRequest.membership_id)
        //todo 'please enter payment' message
    }

    @GetMapping("/{id}/pay")
    fun getPaymentInstructions(
        @PathVariable id: String,
        @RequestBody memberShipIdRequest: MemberShipIdRequest
    ): PaymentInstructions {
        val rental = rentalService.getRental(id.toLong(), memberShipIdRequest.membership_id)
        val payment = paymentService.getPayment(rental.payment?.id, memberShipIdRequest.membership_id)
        val pledge = rental.pledge
        return PaymentInstructions(rental, payment, pledge)
    }

    @PostMapping("/{id}/pay")
    fun payRental(
        @PathVariable id: String,
        @RequestBody paymentRequest: PaymentRequest
    ): ArrayList<CashMachine.AcceptedNotesAndCoins> {
        return rentalService.payRental(id, paymentRequest.membership_id, paymentRequest.payment)
        //todo generate and get SecretKey to unlock vehicle
    }

    @PostMapping("/id/return")
    fun returnVehicle() {
        //todo calculate overtime
        //todo subtract overtime from pledge and return pledge
        //todo create overtime bill for remainder
    }

    class RentalRequest(
        var vehicle_type: String,
        var hours: Int,
        var membership_id: Long
    )

    class PaymentRequest(
        var payment: Array<CashMachine.AcceptedNotesAndCoins>,
        var membership_id: Long
    )

    class PaymentInstructions(
        private val rental: Rental,
        val payment: Payment,
        val pledge: Pledge?
    ) {
        val message = "To pay your payment, go to: POST '/rentals/${rental.id}/pay'"
        val total = "$${payment.amount + (pledge?.amount ?: 0.0F)}"
        val acceptedNotesAndCoins = CashMachine.AcceptedNotesAndCoins.values().map { it to it.worth }.toMap()
    }

    class MemberShipIdRequest(var membership_id: Long)
}
