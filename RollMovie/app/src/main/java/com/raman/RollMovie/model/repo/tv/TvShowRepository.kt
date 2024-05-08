package com.raman.RollMovie.model.repo.tv

import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.model.data.detail.movie.DetailResponse
import com.raman.RollMovie.model.data.detail.tv.TvShowDetail
import kotlinx.coroutines.flow.Flow

interface TvShowRepository {

    suspend fun getPopularTvShow() : Flow<List<MovieModel>>
    suspend fun getTopRatedTvShow() : Flow<List<MovieModel>>
    suspend fun getTrendingTvShow() : Flow<List<MovieModel>>
    suspend fun getOnTheAirTvShow() : Flow<List<MovieModel>>
    suspend fun getDiscoverTvShow() : Flow<List<MovieModel>>
    suspend fun getTvShowDetail(id :Int) : Flow<TvShowDetail>
    suspend fun searchTvShow(title: String) : Flow<List<MovieModel>>

}