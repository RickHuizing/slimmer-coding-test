package rjhuizing.slimmer.coding.test.model.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity(name = "VEHICLE_TYPES")
class VehicleType(
    @Id
    var id: String,

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonBackReference
    var vehicleSuperType: VehicleSuperType,

    @OneToMany(mappedBy = "vehicleType")
    @JsonBackReference
    var vehicles: Set<Vehicle>,

    @Column
    var rentalPrice: Float,

    @Column
    var goldPrice: Float,

    @Column
    var description: String
){
    fun getVehicleAvailable(): Boolean {
        return vehicles.all { !it.isReserved }
    }
}