package com.raman.RollMovie.viewmodel.app

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raman.RollMovie.model.data.MovieModel
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
class AppViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val tvShowRepository: TvShowRepository
) : ViewModel() {

    val isHitError = mutableStateOf(false)
    val inProgress = mutableStateOf(false)

    val isHitErrorTvShow = mutableStateOf(false)
    val inProgressTvShow = mutableStateOf(false)

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

    // Tv Show data flow ->
    private val _popularFlowTvShow = MutableStateFlow<List<MovieModel>?>(null)
    val popularFlowTvShow: StateFlow<List<MovieModel>?> = _popularFlowTvShow

    private val _topRatedFlowTvShow = MutableStateFlow<List<MovieModel>?>(null)
    val topRatedFlowTvShow: StateFlow<List<MovieModel>?> = _topRatedFlowTvShow

    private val _discoverFlowTvShow = MutableStateFlow<List<MovieModel>?>(null)
    val discoverFlowTvShow: StateFlow<List<MovieModel>?> = _discoverFlowTvShow

    private val _trendingFlowTvShow = MutableStateFlow<List<MovieModel>?>(null)
    val trendingFlowTvShow: StateFlow<List<MovieModel>?> = _trendingFlowTvShow

    private val _onTheAirTvShow = MutableStateFlow<List<MovieModel>?>(null)
    val onTheAirTvShow: StateFlow<List<MovieModel>?> = _onTheAirTvShow

    init {
        getRemoteDataMovie()
    }

    // receive movie data from repo ->
    fun getRemoteDataMovie() {
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
                    delay(500)
                    inProgress.value = false
                    isHitError.value = false
                }

        }

    }

    // receive TvShow data from repo ->
    fun getRemoteDataTvShow() {
        viewModelScope.launch {
            inProgressTvShow.value = true

            tvShowRepository.getPopularTvShow()
                .catch {
                    Log.v("exception", it.message!!)
                    inProgressTvShow.value = false
                    isHitErrorTvShow.value = true
                }
                .collect {
                    _popularFlowTvShow.value = it
                }

        }

        viewModelScope.launch {

            tvShowRepository.getTopRatedTvShow()
                .catch {
                    Log.v("exception", it.message!!)
                    inProgressTvShow.value = false
                    isHitErrorTvShow.value = true
                }
                .collect {
                    _topRatedFlowTvShow.value = it
                }

        }

        viewModelScope.launch {

            tvShowRepository.getDiscoverTvShow()
                .catch {
                    Log.v("exception", it.message!!)
                    inProgressTvShow.value = false
                    isHitErrorTvShow.value = true
                }
                .collect {
                    _discoverFlowTvShow.value = it
                }

        }

        viewModelScope.launch {

            tvShowRepository.getTrendingTvShow()
                .catch {
                    Log.v("exception", it.message!!)
                    inProgressTvShow.value = false
                    isHitErrorTvShow.value = true
                }
                .collect {
                    _trendingFlowTvShow.value = it
                }

        }

        viewModelScope.launch {

            tvShowRepository.getOnTheAirTvShow()
                .catch {
                    Log.v("exception", it.message!!)
                    inProgressTvShow.value = false
                    isHitErrorTvShow.value = true
                }
                .collect {
                    _onTheAirTvShow.value = it
                    delay(500)
                    inProgressTvShow.value = false
                    isHitErrorTvShow.value = false
                }

        }

    }

}