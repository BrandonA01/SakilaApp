package com.Sakila.api.SakilaApp;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    //Attributes
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int category_id;
    @Column(name = "name")
    String name;
    @Column(name = "last_update")
    String last_update;
    //date and time formatter
    //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //Constructors
    public Category(String name, String last_update) {
        this.name = name;
        //this.last_update = dtf.format(LocalDateTime.now());
        this.last_update = last_update;
    }

    public Category() {
    }

    //getters and setters


    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}
