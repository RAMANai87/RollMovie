package com.raman.RollMovie.model.repo.movie

import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.model.data.detail.movie.DetailResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getPopularMovie() :Flow<List<MovieModel>>
    suspend fun getTopRatedMovie() :Flow<List<MovieModel>>
    suspend fun getTrendingMovie() :Flow<List<MovieModel>>
    suspend fun getNowPlayingMovie() :Flow<List<MovieModel>>
    suspend fun getUpcomingMovie() :Flow<List<MovieModel>>
    suspend fun getDiscoverMovie() :Flow<List<MovieModel>>
    suspend fun getMovieDetail(id :Int) :Flow<DetailResponse>
    suspend fun searchMovie(title: String) :Flow<List<MovieModel>>

}