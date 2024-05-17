package com.raman.RollMovie.viewmodel.app

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raman.RollMovie.model.data.detail.movie.DetailResponse
import com.raman.RollMovie.model.data.detail.tv.TvShowDetail
import com.raman.RollMovie.model.repo.movie.MovieRepository
import com.raman.RollMovie.model.repo.tv.TvShowRepository
import com.raman.RollMovie.utils.fakeData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val tvShowRepository: TvShowRepository,
    private val movieRepository: MovieRepository
) : ViewModel() {

    val inProgress = mutableStateOf(false)
    val hitError = mutableStateOf(false)

    private val _movieDetail = MutableStateFlow<DetailResponse?>(fakeData)
    val movieDetail: StateFlow<DetailResponse?> = _movieDetail

    private val _tvShowDetail = MutableStateFlow<TvShowDetail?>(null)
    val tvShowDetail: StateFlow<TvShowDetail?> = _tvShowDetail

    fun getMovieDetail(id: Int) {
        viewModelScope.launch {
            inProgress.value = true

            movieRepository.getMovieDetail(id)
                .catch {
                    Log.v("exception", it.message.toString())
                    inProgress.value = false
                    hitError.value = true
                }
                .collect {
                    Log.v("data", it.toString())
                    _movieDetail.value = it
                    inProgress.value = false
                    hitError.value = false
                }

        }
    }

    fun getTvShowDetail(id: Int) {

        viewModelScope.launch {
            inProgress.value = true

            tvShowRepository.getTvShowDetail(id)
                .catch {
                    Log.v("exception", it.message.toString())
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

}