package com.Sakila.api.SakilaApp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

    @Query(value ="SELECT * FROM actor a WHERE (:first_name is null or a.first_name = :first_name) AND (:last_name is null or a.last_name = :last_name)",
            nativeQuery = true)
    Iterable<Actor> searchByFirstAndOrLastName(@Param("first_name") String first_name,
                                               @Param("last_name") String last_name);

}