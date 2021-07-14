package rjhuizing.slimmer.coding.test.model.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity(name = "MEMBER_SHIPS")
class MemberShip(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonManagedReference
    var customer: Customer,

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_ship_type_id", referencedColumnName = "id")
    var memberShipType: MemberShipType,

    @Column
    var isActive: Boolean,

    ) {
    @OneToMany(mappedBy = "memberShip")
    @JsonBackReference
    var rentals: Set<Rental> = setOf()

}