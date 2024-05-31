package com.raman.RollMovie.viewmodel.search

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.model.repo.movie.MovieRepository
import com.raman.RollMovie.model.repo.tv.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val tvShowRepository: TvShowRepository
) : ViewModel() {

    val inProgress = mutableStateOf(false)
    val hitError = mutableStateOf(false)

    private val _dataSearch = MutableStateFlow<List<MovieModel>?>(null)
    val dataSearch: StateFlow<List<MovieModel>?> = _dataSearch

    fun getSearchMovie(text: String) {
        viewModelScope.launch {

            inProgress.value = true
            hitError.value = false

            movieRepository.searchMovie(text)
                .catch {
                    hitError.value = true
                    inProgress.value = false
                    Log.v("error", it.message!!)
                }
                .collect {
                    _dataSearch.value = it
                    inProgress.value = false
                    hitError.value = false
                }

        }
    }

    fun getSearchTvShow(text: String) {

        viewModelScope.launch {

            inProgress.value = true
            hitError.value = false

            tvShowRepository.searchTvShow(text)
                .catch {
                    hitError.value = true
                    inProgress.value = false
                }
                .collect {
                    _dataSearch.value = it
                    inProgress.value = false
                    hitError.value = false
                }

        }

    }

}