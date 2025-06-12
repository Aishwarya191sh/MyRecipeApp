package eu.tutorials.myrecipieapp

sealed class Screen(val route:String) {
    object  RecipeScreen:Screen("recipeScreen")
    object DetailScreen:Screen("detailScreen")

}