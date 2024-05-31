package com.raman.RollMovie.model.repo.movie

import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.model.data.detail.movie.DetailResponse
import com.raman.RollMovie.model.db.MovieDao
import com.raman.RollMovie.utils.mapper.httpMapperMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource
) :MovieRepository{
    override suspend fun getPopularMovie(): Flow<List<MovieModel>> {
        return movieRemoteDataSource.fetchPopularMovie
            .map { movieResult ->
                movieResult.map {
                    httpMapperMovie(it)
                }
            }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun getTopRatedMovie(): Flow<List<MovieModel>> {
        return movieRemoteDataSource.fetchTopRatedMovie
            .map { movieResult ->
                movieResult.map {
                    httpMapperMovie(it)
                }
            }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun getTrendingMovie(): Flow<List<MovieModel>> {
        return movieRemoteDataSource.fetchTrendingMovie
            .map { movieResult ->
                movieResult.map {
                    httpMapperMovie(it)
                }
            }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun getNowPlayingMovie(): Flow<List<MovieModel>> {
        return movieRemoteDataSource.fetchNowPlayingMovie
            .map { movieResult ->
                movieResult.map {
                    httpMapperMovie(it)
                }
            }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun getUpcomingMovie(): Flow<List<MovieModel>> {
        return movieRemoteDataSource.fetchUpComingMovie
            .map { movieResult ->
                movieResult.map {
                    httpMapperMovie(it)
                }
            }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun getDiscoverMovie(): Flow<List<MovieModel>> {
        return movieRemoteDataSource.fetchDiscoverMovie
            .map { movieResult ->
                movieResult.map {
                    httpMapperMovie(it)
                }
            }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun getMovieDetail(id :Int): Flow<DetailResponse> {
        return movieRemoteDataSource.fetchMovieDetail(id)
            .flowOn(Dispatchers.IO)
    }

    override suspend fun searchMovie(title :String): Flow<List<MovieModel>> {
        return movieRemoteDataSource.searchMovie(title)
            .map { movieResult ->
                movieResult.map {
                    httpMapperMovie(it)
                }
            }
            .flowOn(Dispatchers.IO)
    }

}