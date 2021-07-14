package rjhuizing.slimmer.coding.test.model.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity(name = "MEMBER_SHIP_TYPES")
class MemberShipType(
    @Id
    var id: String,

    @Column(nullable = false)
    var paysPledge: Boolean,

    @OneToMany(mappedBy = "memberShipType")
    @JsonBackReference
    var memberShips: Set<MemberShip>
)