package rjhuizing.slimmer.coding.test.model.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import lombok.Setter
import javax.persistence.*

@Entity(name = "VEHICLES")
class Vehicle(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonManagedReference
    var vehicleType: VehicleType,

    @Column
    var location: String,

    @Column
    @Setter
    var isReserved: Boolean,

    @Column
    var secretKey: String?
)