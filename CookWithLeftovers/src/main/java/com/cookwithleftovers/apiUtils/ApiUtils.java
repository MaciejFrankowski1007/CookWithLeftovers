package com.cookwithleftovers.apiUtils;
import java.util.List;

public class ApiUtils {
    public static List<String> searchRecipes(List<String> ingredients) {
        String query = String.join(",", ingredients);
        System.out.println("Searching recipes for: " + query);
        return List.of(
            "https://example.com/recipe1",
            "https://example.com/recipe2"
        );
    }
}
