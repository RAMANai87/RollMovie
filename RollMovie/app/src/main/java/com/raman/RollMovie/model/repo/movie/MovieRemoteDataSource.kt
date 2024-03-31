package com.raman.RollMovie.model.repo.movie

import com.raman.RollMovie.model.api.ApiService
import com.raman.RollMovie.model.data.HttpResult
import com.raman.RollMovie.model.data.detail.movie.DetailResponse
import com.raman.RollMovie.model.data.movie.MovieResult
import com.raman.RollMovie.model.data.movie.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {

    val fetchPopularMovie: Flow<List<Result>> = flow {
        while (true) {
            val result = apiService.getPopularMovies().results
            emit(result)
        }
    }

    val fetchTopRatedMovie: Flow<List<Result>> = flow {
        while (true) {
            val result = apiService.getTopRatedMovies().results
            emit(result)
        }
    }

    val fetchTrendingMovie: Flow<List<Result>> = flow {
        while (true) {
            val result = apiService.getTrendingMovies().results
            emit(result)
        }
    }

    val fetchNowPlayingMovie: Flow<List<Result>> = flow {
        while (true) {
            val result = apiService.getNowPlayingMovies().results
            emit(result)
        }
    }

    val fetchUpComingMovie: Flow<List<Result>> = flow {
        while (true) {
            val result = apiService.getUpcomingMovies().results
            emit(result)
        }
    }

    val fetchDiscoverMovie: Flow<List<Result>> = flow {
        while (true) {
            val result = apiService.getDiscoverMovies().results
            emit(result)
        }
    }

    fun fetchMovieDetail(id: Int): Flow<DetailResponse> = flow {
        val result = apiService.getDetailsMovieById(id)
        emit(result)
    }

    fun searchMovie(movieName :String): Flow<List<Result>> = flow {
        val result = apiService.searchMovie(movieName).results
        emit(result)
    }

}