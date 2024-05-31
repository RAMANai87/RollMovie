package com.raman.RollMovie.viewmodel.favorite

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raman.RollMovie.model.data.FavoriteModel
import com.raman.RollMovie.model.repo.favorite.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) : ViewModel() {

    val inProgress = mutableStateOf(false)

    val isFavorite = mutableStateOf(false)

    private val _favoriteMovie = MutableStateFlow<List<FavoriteModel>?>(null)
    val favoriteMovie: StateFlow<List<FavoriteModel>?> = _favoriteMovie

    init {
        getAllFavoriteMovie()
    }

    fun getAllFavoriteMovie() {
        viewModelScope.launch {
            inProgress.value = true
            val result = favoriteRepository.getAllFavoriteMovies()
            _favoriteMovie.value = result
            inProgress.value = false
        }
    }

    fun insertData(data: FavoriteModel) {
        viewModelScope.launch {
            favoriteRepository.insertFavoriteMovie(data)
        }
    }

    fun deleteData(data: FavoriteModel) {
        viewModelScope.launch {
            favoriteRepository.deleteFavoriteMovie(data)
        }
    }

    fun searchFavoriteMovie(id: Int) {
        viewModelScope.launch {
            isFavorite.value = favoriteRepository.searchFavoriteMovie(id)
        }
    }

}