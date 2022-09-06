package com.Sakila.api.SakilaApp.Repositories;

import com.Sakila.api.SakilaApp.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
