package com.raman.RollMovie.viewmodel.app

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.model.repo.movie.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    val isHitError = mutableStateOf(false)
    val inProgress = mutableStateOf(false)

    // movies data flow ->

    private val _popularFlow = MutableStateFlow<List<MovieModel>?>(null)
    val popularFlow: StateFlow<List<MovieModel>?> = _popularFlow

    private val _topRatedFlow = MutableStateFlow<List<MovieModel>?>(null)
    val topRatedFlow: StateFlow<List<MovieModel>?> = _topRatedFlow

    private val _discoverFlow = MutableStateFlow<List<MovieModel>?>(null)
    val discoverFlow: StateFlow<List<MovieModel>?> = _discoverFlow

    private val _trendingFlow = MutableStateFlow<List<MovieModel>?>(null)
    val trendingFlow: StateFlow<List<MovieModel>?> = _trendingFlow

    private val _nowPlayingFlow = MutableStateFlow<List<MovieModel>?>(null)
    val nowPlayingFlow: StateFlow<List<MovieModel>?> = _nowPlayingFlow

    private val _upComingFlow = MutableStateFlow<List<MovieModel>?>(null)
    val upComingFlow: StateFlow<List<MovieModel>?> = _upComingFlow

    init {
        getRemoteData()
    }

    fun getRemoteData() {
        viewModelScope.launch {
            inProgress.value = true

            movieRepository.getPopularMovie()
                .catch {
                    Log.v("exception", it.message!!)
                    inProgress.value = false
                    isHitError.value = true
                }
                .collect {
                    _popularFlow.value = it
                }

        }

        viewModelScope.launch {

            movieRepository.getTopRatedMovie()
                .catch {
                    Log.v("exception", it.message!!)
                    inProgress.value = false
                    isHitError.value = true
                }
                .collect {
                    _topRatedFlow.value = it
                }

        }

        viewModelScope.launch {

            movieRepository.getDiscoverMovie()
                .catch {
                    Log.v("exception", it.message!!)
                    inProgress.value = false
                    isHitError.value = true
                }
                .collect {
                    _discoverFlow.value = it
                }

        }

        viewModelScope.launch {

            movieRepository.getTrendingMovie()
                .catch {
                    Log.v("exception", it.message!!)
                    inProgress.value = false
                    isHitError.value = true
                }
                .collect {
                    _trendingFlow.value = it
                }

        }

        viewModelScope.launch {

            movieRepository.getUpcomingMovie()
                .catch {
                    Log.v("exception", it.message!!)
                    inProgress.value = false
                    isHitError.value = true
                }
                .collect {
                    _upComingFlow.value = it
                }

        }

        viewModelScope.launch {

            movieRepository.getNowPlayingMovie()
                .catch {
                    Log.v("exception", it.message!!)
                    inProgress.value = false
                    isHitError.value = true
                }
                .collect {
                    _nowPlayingFlow.value = it
                    inProgress.value = false
                    isHitError.value = false
                }

        }

    }

}