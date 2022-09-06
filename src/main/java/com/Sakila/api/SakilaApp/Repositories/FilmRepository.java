package com.Sakila.api.SakilaApp.Repositories;

import com.Sakila.api.SakilaApp.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface FilmRepository extends CrudRepository<Film, Integer>, JpaRepository<Film, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update Film u set u.release_year = :release_year where u.film_id = :Id",
    nativeQuery = true)
    void setInfoById(@Param("Id")Integer Id, @Param("release_year")Integer release_year);

    @Query(value = "SELECT sakila.film_actor.film_id,  sakila.film_actor.actor_id,  sakila.film.title " +
            "FROM ((sakila.film_actor " +
            "INNER JOIN sakila.actor ON sakila.film_actor.actor_id) " +
            "INNER JOIN sakila.film ON sakila.film_actor.film_id) " +
            "WHERE sakila.actor.actor_id = sakila.film_actor.actor_id " +
            "AND sakila.film.film_id = sakila.film_actor.film_id " +
            "AND sakila.actor.actor_id = :actor_id",
    nativeQuery = true)
    Iterable<Object> getFilmsByActor(@Param("actor_id") Integer actor_id);
}
