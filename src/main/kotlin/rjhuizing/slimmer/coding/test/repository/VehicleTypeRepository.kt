package rjhuizing.slimmer.coding.test.repository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import rjhuizing.slimmer.coding.test.model.entities.VehicleType


@RepositoryRestResource(collectionResourceRel = "vehicle_types", path = "vehicle_types")
interface VehicleTypeRepository : PagingAndSortingRepository<VehicleType?, String?>
