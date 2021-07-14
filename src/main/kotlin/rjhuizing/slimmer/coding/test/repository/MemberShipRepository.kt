package rjhuizing.slimmer.coding.test.repository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import rjhuizing.slimmer.coding.test.model.entities.MemberShip


@RepositoryRestResource(collectionResourceRel = "memberships", path = "memberships")
interface MemberShipRepository : PagingAndSortingRepository<MemberShip?, Long?>
