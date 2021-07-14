package rjhuizing.slimmer.coding.test.model.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity(name = "VEHICLE_SUPER_TYPES")
class VehicleSuperType(
    @Id
    var id: String,

    @Column
    var description: String,

    @Column
    var pledgeAmount: Float,

    @OneToMany(mappedBy = "vehicleSuperType")
    @JsonManagedReference
    var vehicleTypes: Set<VehicleType>,
)