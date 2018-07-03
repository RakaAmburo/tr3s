package com.project.tres.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.tres.entities.Person;

//ver projjections?


@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

  List<Person> findByLastName(@Param("name") String name);
  
  @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
  public List<Person> find(@Param("lastName") String lastName);

}
