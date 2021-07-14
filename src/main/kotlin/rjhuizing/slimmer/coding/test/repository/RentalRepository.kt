package rjhuizing.slimmer.coding.test.repository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import rjhuizing.slimmer.coding.test.model.entities.Rental


@RepositoryRestResource(collectionResourceRel = "rentals", path = "rentals")
interface RentalRepository : PagingAndSortingRepository<Rental?, Long?>
