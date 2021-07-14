package rjhuizing.slimmer.coding.test.repository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import rjhuizing.slimmer.coding.test.model.entities.Payment


@RepositoryRestResource(collectionResourceRel = "payments", path = "payments")
interface PaymentRepository : PagingAndSortingRepository<Payment?, Long?>
