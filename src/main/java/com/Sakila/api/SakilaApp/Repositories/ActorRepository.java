package com.Sakila.api.SakilaApp.Repositories;

import com.Sakila.api.SakilaApp.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

    @Query(value ="SELECT * FROM actor a WHERE (:first_name is null or a.first_name = :first_name) AND (:last_name is null or a.last_name = :last_name)",
            nativeQuery = true)
    Iterable<Actor> searchByFirstAndOrLastName(@Param("first_name") String first_name,
                                               @Param("last_name") String last_name);

    @Query(value ="SELECT * FROM actor a WHERE :actor_id = a.actor_id",
            nativeQuery = true)
    Actor ActorById(@Param("actor_id") Integer actor_id);

    @Query(value = "SELECT sakila.film_actor.film_id,  sakila.film_actor.actor_id,  sakila.actor.first_name, sakila.actor.last_name" +
            "FROM ((sakila.film_actor" +
            "INNER JOIN sakila.actor ON sakila.film_actor.actor_id)" +
            "INNER JOIN sakila.film ON sakila.film_actor.film_id)" +
            "WHERE sakila.actor.actor_id = sakila.film_actor.actor_id" +
            "AND sakila.film.film_id = sakila.film_actor.film_id", nativeQuery = true)
    Iterable<Object> getActors();

    @Query(value = "SELECT sakila.film_actor.film_id,  sakila.film_actor.actor_id,  sakila.actor.first_name, sakila.actor.last_name" +
            "FROM ((sakila.film_actor" +
            "INNER JOIN sakila.actor ON sakila.film_actor.actor_id)" +
            "INNER JOIN sakila.film ON sakila.film_actor.film_id)" +
            "WHERE sakila.actor.actor_id = sakila.film_actor.actor_id" +
            "AND sakila.film.film_id = sakila.film_actor.film_id" +
            "AND sakila.film.film_id = :film_id", nativeQuery = true)
    Iterable<Object> getActorsFromFilm(@Param("film_id") Integer film_id);

}