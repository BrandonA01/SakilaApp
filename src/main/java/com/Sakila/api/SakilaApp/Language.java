package com.Sakila.api.SakilaApp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "language")
public class Language {
    //Attributes
    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer lang_id;
    @Column(name = "name")
    String name;
    @Column(name = "last_update")
    Date last_update;

    //Constructors
    Language(Integer lang_id, String name, Date last_update){
        this.lang_id = lang_id;
        this.name = name;
        this.last_update = last_update;
    }
    Language(){}

    //Methods
    public Integer getLang_id() {
        return lang_id;
    }

    public void setLang_id(Integer lang_id) {
        this.lang_id = lang_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
