package rjhuizing.slimmer.coding.test.model.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity(name = "PAYMENTS")
class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,

    @OneToOne(mappedBy = "payment")
    @JsonBackReference
    var rental: Rental,

    @Column
    var amount: Float,

    @Column
    var isPaid: Boolean
)