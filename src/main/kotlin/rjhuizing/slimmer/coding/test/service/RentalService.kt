package rjhuizing.slimmer.coding.test.service

import org.springframework.stereotype.Service
import rjhuizing.slimmer.coding.test.exception.RentalException
import rjhuizing.slimmer.coding.test.model.CashMachine
import rjhuizing.slimmer.coding.test.model.entities.*
import rjhuizing.slimmer.coding.test.repository.*
import java.sql.Time
import java.time.LocalTime

/**
 * Owns the methods used in renting vehicles
 * todo test methods
 */
@Service
class RentalService(
    var rentalRepository: RentalRepository,
    var vehicleRepository: VehicleRepository,
    var vehicleTypeRepository: VehicleTypeRepository,
    var memberShipRepository: MemberShipRepository,
    var paymentService: PaymentService
) {
    fun getRental(id: Long, membershipId: Long): Rental {
        val rental = rentalRepository.findById(id)
        if (rental.isEmpty || rental.get().memberShip.id != membershipId)
            throw RentalException("Rental with id $id doesn't exist or isn't owned by membership $membershipId")
        return rental.get()
    }

    fun payRental(
        id: String, membershipId: Long, enteredCash: Array<CashMachine.AcceptedNotesAndCoins>
    ): ArrayList<CashMachine.AcceptedNotesAndCoins> {
        val rental = getRental(id.toLong(), membershipId)
        val payment = paymentService.getPayment(rental.payment?.id, membershipId)

        val pledge = rental.pledge
        val toBePayed = payment.amount + (pledge?.amount ?: 0.0F)
        val cashBack = CashMachine.calculateCashback(toBePayed.toDouble(), enteredCash)
        setRentalAsPaid(rental)
        return cashBack
    }

    private fun setRentalAsPaid(rental: Rental) {
        rental.payment?.isPaid = true
        rental.pledge?.isPaid = true
        rental.pledge?.isCashBackComplete = false
        rentalRepository.save(rental)
    }

    fun rentVehicle(vehicleTypeId: String, hours: Int, membershipId: Long): Rental {
        val memberShip = validateRental(hours, membershipId)
        val vehicle = checkIfVehicleAvailable(vehicleTypeId)
        reserveVehicle(vehicle) //todo what if pledge not paid
        val rentalTime = Time.valueOf(LocalTime.of(hours, 0))

        var rental = Rental(memberShip, vehicle, rentalTime)
        rental.pledge = getPledge(rental)
        rental.payment = createPayment(rental)
        rental = rentalRepository.save(rental)
        return rental
    }

    private fun validateRental(hours: Int, membershipId: Long): MemberShip {
        val memberShip = memberShipRepository.findById(membershipId)
        if (memberShip.isEmpty) {
            throw RentalException("unknown membership ID")
        }
        if (hours < 4) {
            throw RentalException("Vehicles can be rented for a minimum of 4 hours")
        }
        if (memberShip.get().rentals.any { it.isActive ?: false }) {
            throw RentalException("Can't rent vehicle while renting other vehicle")
        }
        return memberShip.get()
    }

    private fun checkIfVehicleAvailable(vehicleTypeId: String): Vehicle {
        val vehicleType = vehicleTypeRepository.findById(vehicleTypeId)
        if (vehicleType.isEmpty) {
            throw RentalException("Vehicle type ${vehicleType.get().id} doesn't exist")
        }
        val availableVehicle = vehicleType.get().vehicles.find { !it.isReserved }
        if (!vehicleType.get().getVehicleAvailable() || availableVehicle == null) {
            throw RentalException("No vehicles of type ${vehicleType.get().id} are available.")
        }
        return availableVehicle
    }

    private fun reserveVehicle(vehicle: Vehicle): Vehicle {
        vehicle.isReserved = true
        return vehicleRepository.save(vehicle)
    }

    private fun unreserveVehicle(vehicle: Vehicle) {
        vehicle.isReserved = false
        vehicleRepository.save(vehicle)
    }

    private fun getPledge(rental: Rental): Pledge {
        var pledgeAmount = 0F
        if (rental.memberShip.memberShipType.paysPledge)
            pledgeAmount = rental.vehicle.vehicleType.vehicleSuperType.pledgeAmount
        return Pledge(null, rental, pledgeAmount, pledgeAmount == 0F, pledgeAmount == 0F)
    }

    private fun createPayment(rental: Rental): Payment {
        val vehiclePrice = when (rental.memberShip.memberShipType.id) {
            "Gold" -> rental.vehicle.vehicleType.goldPrice
            else -> rental.vehicle.vehicleType.rentalPrice
        }
        val paymentAmount = vehiclePrice * rental.rentalTime.hours
        return Payment(null, rental, paymentAmount, paymentAmount == 0F)
    }

    fun getAllVehicleTypes(): MutableIterable<VehicleType?> {
        return vehicleTypeRepository.findAll()
    }

}