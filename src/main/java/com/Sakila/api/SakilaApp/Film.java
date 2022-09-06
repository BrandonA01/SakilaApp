package com.Sakila.api.SakilaApp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)@Entity
@Table(name = "film")
public class Film {

    //Attributes
    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer filmid;
    @Column(name = "title")
    String title;
    @Column(name = "description")
    String description;
    @Column(name = "release_year")
    Date release_year;
    @Column(name = "language_id")
    Integer language_id;
    @Column(name = "rental_duration")
    Integer rental_duration;
    @Column(name = "rental_rate")
    double rental_rate;
    @Column(name = "length")
    Integer length;
    @Column(name = "replacement_cost")
    double replacement_cost;
    @Column(name = "rating")
    String rating;
    @Transient
    @Column(name = "special_features")
    Set<String> special_features;
    @Column(name = "last_update")
    Date last_update;
    @Column(name = "star_rating")
    Integer star_rating;

    //Constructors
    public Film(Integer filmid, String title, String description, Date release_year, Integer language_id,
                Integer rental_duration, Integer rental_rate, Integer length, double replacement_cost, String rating, Set<String> special_features, Date last_update, Integer star_rating) {
        this.filmid = filmid;
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language_id = language_id;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.special_features = special_features;
        this.last_update = last_update;
        this.star_rating = star_rating;
    }

    public Film() {
    }

    //Methods
    public int getFilmid() {
        return filmid;
    }

    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Date release_year) {
        this.release_year = release_year;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public double getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(double rental_rate) {
        this.rental_rate = rental_rate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(double replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Set<String> getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(Set<String> special_features) {
        this.special_features = special_features;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public int getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(int star_rating) {
        this.star_rating = star_rating;
    }
}

enum Rating {
    G("G"),
    PG("PG"),
    PG13("PG-13"),
    R("R"),
    NC17("NC-17");

    private String value;

    Rating(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Rating getEnum(String value) {
        if (value == null)
            throw new IllegalArgumentException();
        for (Rating v : values())
            if (value.equalsIgnoreCase(v.getValue())) return v;
        throw new IllegalArgumentException();

    }
}
