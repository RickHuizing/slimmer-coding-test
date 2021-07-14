package rjhuizing.slimmer.coding.test.repository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import rjhuizing.slimmer.coding.test.model.entities.Bill


@RepositoryRestResource(collectionResourceRel = "bills", path = "bills")
interface BillRepository : PagingAndSortingRepository<Bill?, Long?>
