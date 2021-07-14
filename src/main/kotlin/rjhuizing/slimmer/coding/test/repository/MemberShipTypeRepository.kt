package rjhuizing.slimmer.coding.test.repository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import rjhuizing.slimmer.coding.test.model.entities.MemberShipType


@RepositoryRestResource(collectionResourceRel = "membership_types", path = "membership_types")
interface MemberShipTypeRepository : PagingAndSortingRepository<MemberShipType?, String?>
