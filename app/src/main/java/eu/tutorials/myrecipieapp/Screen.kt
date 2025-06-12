package eu.tutorials.myrecipieapp

sealed class Screen(val route:String) {
    object  RecipeScreen:Screen("recipescreen")
    object DetailScreen:Screen("detailscreen")

}