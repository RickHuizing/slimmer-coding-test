package rjhuizing.slimmer.coding.test.repository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import rjhuizing.slimmer.coding.test.model.entities.VehicleSuperType


@RepositoryRestResource(collectionResourceRel = "vehicle_super_types", path = "vehicle_super_types")
interface VehicleSuperTypeRepository : PagingAndSortingRepository<VehicleSuperType?, String?>
