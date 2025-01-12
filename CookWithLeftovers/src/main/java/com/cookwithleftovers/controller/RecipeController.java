package com.cookwithleftovers.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cookwithleftovers.apiUtils.ApiUtils;

@Controller
public class RecipeController {

    @GetMapping("/recipes/search")
    public String searchRecipes(String ingredients, Model model) {
        List<String> ingredientList = Arrays.asList(ingredients.split(","));
        List<String> recipes = ApiUtils.searchRecipes(ingredientList);
        model.addAttribute("results", recipes);
        return "search";
    }
}
