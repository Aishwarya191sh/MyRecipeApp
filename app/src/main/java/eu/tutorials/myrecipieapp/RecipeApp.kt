package eu.tutorials.myrecipieapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel:MainViewModel= viewModel()
    val viewstate by recipeViewModel.categoriesState
    NavHost(navController =navController, startDestination = Screen.RecipeScreen.route){
        composable(route=Screen.RecipeScreen.route){
            RecipieScreen(viewState = viewstate, navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                navController.navigate(Screen.DetailScreen.route)
            })

        }
        composable(route=Screen.DetailScreen.route){
           val category=navController.previousBackStackEntry?.
            savedStateHandle?.get<Category>("cat") ?: Category("","","","")
           CategoryDetailScreen(category = category)
        }

    }
}