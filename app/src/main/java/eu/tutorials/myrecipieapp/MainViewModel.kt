package eu.tutorials.myrecipieapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _categorieState= mutableStateOf(RecipieState())
    val categoriesState: State<RecipieState> =_categorieState

    init {
        fetchCategories()
    }

    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                val response= recipieService.getCategories()
                _categorieState.value=_categorieState.value.copy(
                    list=response.categories,
                    loading = false,
                    error=null
                )
            } catch (e:Exception){
                _categorieState.value=_categorieState.value.copy(
                    loading = false,
                    error="Error fetching categories ${e.message}"
                )
            }
        }
    }

    data class RecipieState(
        var loading:Boolean=true,
        var list: List<Category> = emptyList(),
        var error: String? = null
    )
}