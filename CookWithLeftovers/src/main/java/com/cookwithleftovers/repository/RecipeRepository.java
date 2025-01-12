package com.cookwithleftovers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookwithleftovers.domain.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByTitleContaining(String title);
}
