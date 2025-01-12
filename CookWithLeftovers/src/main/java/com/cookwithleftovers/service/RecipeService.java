package com.cookwithleftovers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookwithleftovers.domain.Recipe;
import com.cookwithleftovers.repository.RecipeRepository;



@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> searchRecipes(String title) {
        return recipeRepository.findByTitleContaining(title);
    }
}
