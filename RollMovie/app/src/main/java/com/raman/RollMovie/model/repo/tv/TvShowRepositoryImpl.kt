package com.raman.RollMovie.model.repo.tv

import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.model.data.detail.tv.TvShowDetail
import com.raman.RollMovie.model.db.MovieDao
import com.raman.RollMovie.utils.mapper.httpMapperTvShow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class TvShowRepositoryImpl @Inject constructor(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val movieDao: MovieDao
) : TvShowRepository {
    override suspend fun getPopularTvShow(): Flow<List<MovieModel>> {
        return tvShowRemoteDataSource.fetchPopularTvShow
            .map { tvResult ->
                tvResult.map {
                    httpMapperTvShow(it)
                }
            }
            .onEach {
                movieDao.insertMovies(it)
            }
    }

    override suspend fun getTopRatedTvShow(): Flow<List<MovieModel>> {
        return tvShowRemoteDataSource.fetchTopRatedTvShow
            .map { tvResult ->
                tvResult.map {
                    httpMapperTvShow(it)
                }
            }
            .onEach {
                movieDao.insertMovies(it)
            }
    }

    override suspend fun getTrendingTvShow(): Flow<List<MovieModel>> {
        return tvShowRemoteDataSource.fetchTrendingTvShow
            .map { tvResult ->
                tvResult.map {
                    httpMapperTvShow(it)
                }
            }
            .onEach {
                movieDao.insertMovies(it)
            }
    }

    override suspend fun getOnTheAirTvShow(): Flow<List<MovieModel>> {
        return tvShowRemoteDataSource.fetchOnTheAirTvShow
            .map { tvResult ->
                tvResult.map {
                    httpMapperTvShow(it)
                }
            }
            .onEach {
                movieDao.insertMovies(it)
            }
    }

    override suspend fun getDiscoverTvShow(): Flow<List<MovieModel>> {
        return tvShowRemoteDataSource.fetchDiscoverTvShow
            .map { tvResult ->
                tvResult.map {
                    httpMapperTvShow(it)
                }
            }
            .onEach {
                movieDao.insertMovies(it)
            }
    }

    override suspend fun getTvShowDetail(id: Int): Flow<TvShowDetail>{
        return tvShowRemoteDataSource.fetchTvShowDetail(id)
    }

    override suspend fun searchTvShow(title: String): Flow<List<MovieModel>> {
        return tvShowRemoteDataSource.searchTvShow(title)
            .map { movieResult ->
                movieResult.map {
                    httpMapperTvShow(it)
                }
            }
            .onEach {
                movieDao.insertMovies(it)
            }
    }
}