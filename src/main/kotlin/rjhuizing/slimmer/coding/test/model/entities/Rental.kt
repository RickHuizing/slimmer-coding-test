package rjhuizing.slimmer.coding.test.model.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.sql.Time
import java.sql.Timestamp
import java.time.Instant
import javax.persistence.*

@Entity(name = "RENTALS")
class Rental(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_ship_id", referencedColumnName = "id")
    @JsonManagedReference
    var memberShip: MemberShip,

    @ManyToOne(optional = false)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    var vehicle: Vehicle,

    @Column
    var rentalTime: Time,

    @Column
    var timeOfReturn: Timestamp?,

    @Column
    var timeOfRental: Timestamp? = now(),

    @Column
    var isActive: Boolean? = false,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "pledge_id", referencedColumnName = "id")
    @JsonManagedReference
    var pledge: Pledge?,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    @JsonManagedReference
    var payment: Payment?,

    @OneToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id")
    @JsonManagedReference
    var bill: Bill?,
) {
    constructor(memberShip: MemberShip, vehicle: Vehicle, rentalTime: Time) : this(
        null,
        memberShip,
        vehicle,
        rentalTime,
        null,
        null,
        true,
        null,
        null,
        null
    )

    fun returnCar() {
        timeOfReturn = now()
    }
}

fun now(): Timestamp {
    return Timestamp.from(Instant.now())
}