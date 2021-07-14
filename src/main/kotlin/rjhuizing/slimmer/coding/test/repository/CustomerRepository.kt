package rjhuizing.slimmer.coding.test.repository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import rjhuizing.slimmer.coding.test.model.entities.Customer


@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
interface CustomerRepository : PagingAndSortingRepository<Customer?, Long?> {
    fun findByName(@Param("name") name: String?): List<Customer?>?
}
