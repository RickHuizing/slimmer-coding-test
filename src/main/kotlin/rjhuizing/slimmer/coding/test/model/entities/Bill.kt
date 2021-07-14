package rjhuizing.slimmer.coding.test.model.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity(name = "BILLS")
class Bill(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,

    @OneToOne(mappedBy = "bill")
    @JsonBackReference
    var rental: Rental,

    @Column
    var amount: Float,

    @Column
    var isPaid: Boolean,

    @Column
    var reason: String
)