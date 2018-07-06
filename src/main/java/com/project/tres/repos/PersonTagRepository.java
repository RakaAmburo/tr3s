package com.project.tres.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.tres.entities.PersonTag;

@RepositoryRestResource(collectionResourceRel = "tags", path = "tags")
public interface PersonTagRepository extends PagingAndSortingRepository<PersonTag, Long> {

}
