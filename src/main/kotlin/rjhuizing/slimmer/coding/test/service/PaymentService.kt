package rjhuizing.slimmer.coding.test.service

import org.springframework.stereotype.Service
import rjhuizing.slimmer.coding.test.exception.RentalException
import rjhuizing.slimmer.coding.test.model.CashMachine
import rjhuizing.slimmer.coding.test.model.entities.Payment
import rjhuizing.slimmer.coding.test.repository.*

@Service
class PaymentService(
    var paymentRepository: PaymentRepository
) {
    /**
     * Retrieve a payment from the database and validate user
     */
    fun getPayment(paymentId: Long?, membershipId: Long): Payment {
        if (paymentId == null) throw RentalException("Rental doesn't have an available payment")
        val payment = paymentRepository.findById(paymentId)
        if (payment.isEmpty || payment.get().rental.memberShip.id != membershipId) {
            throw RentalException("Payment doesn't exist or isn't registered under membership: $membershipId")
        }
        return payment.get()
    }
}