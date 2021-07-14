package rjhuizing.slimmer.coding.test.model.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity(name = "CUSTOMERS")
class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,

    @Column
    var name: String,

//    @OneToMany(mappedBy = "customer")
//    @JsonBackReference
//    var memberShips: Set<MemberShip>? = setOf()
) {

}
