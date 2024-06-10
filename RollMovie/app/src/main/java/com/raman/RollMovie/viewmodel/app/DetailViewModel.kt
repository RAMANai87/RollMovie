package com.raman.RollMovie.viewmodel.app

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raman.RollMovie.model.data.detail.movie.DetailResponse
import com.raman.RollMovie.model.data.detail.tv.TvShowDetail
import com.raman.RollMovie.model.repo.movie.MovieRepository
import com.raman.RollMovie.model.repo.tv.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val tvShowRepository: TvShowRepository,
    private val movieRepository: MovieRepository
) : ViewModel() {

    val inProgress = mutableStateOf(true)
    val hitError = mutableStateOf(true)

    private val _movieDetail = MutableStateFlow<DetailResponse?>(null)
    val movieDetail: StateFlow<DetailResponse?> = _movieDetail

    private val _tvShowDetail = MutableStateFlow<TvShowDetail?>(null)
    val tvShowDetail: StateFlow<TvShowDetail?> = _tvShowDetail

    fun getMovieDetail(id: Int) {
        viewModelScope.launch {
            inProgress.value = true

            movieRepository.getMovieDetail(id)
                .catch {
                    inProgress.value = false
                    hitError.value = true
                }
                .collect {
                    _movieDetail.value = it
                    inProgress.value = false
                    hitError.value = false
                    Log.v("data3", it.toString())
                }

        }
    }

    fun getTvShowDetail(id: Int) {

        viewModelScope.launch {
            inProgress.value = true

            tvShowRepository.getTvShowDetail(id)
                .catch {
                    inProgress.value = false
                    hitError.value = true
                }
                .collect {
                    _tvShowDetail.value = it
                    inProgress.value =false
                    hitError.value = false
                }
        }

    }

    fun deleteDataForBackPressed() {
        viewModelScope.launch {
            delay(100)
            _movieDetail.value = null
            _tvShowDetail.value = null
        }
    }

}