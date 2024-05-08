package com.raman.RollMovie.model.repo.tv

import com.raman.RollMovie.model.api.ApiService
import com.raman.RollMovie.model.data.detail.tv.TvShowDetail
import com.raman.RollMovie.model.data.tv.ResultTvShow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TvShowRemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {

    val fetchPopularTvShow: Flow<List<ResultTvShow>> = flow {
        while (true) {
            val result = apiService.getPopularTvShow().results
            emit(result)
        }
    }

    val fetchTopRatedTvShow: Flow<List<ResultTvShow>> = flow {
        while (true) {
            val result = apiService.getTopRatedTvShow().results
            emit(result)
        }
    }

    val fetchTrendingTvShow: Flow<List<ResultTvShow>> = flow {
        while (true) {
            val result = apiService.getTrendingTvShow().results
            emit(result)
        }
    }

    val fetchOnTheAirTvShow: Flow<List<ResultTvShow>> = flow {
        while (true) {
            val result = apiService.getOnTheAirTvShow().results
            emit(result)
        }
    }

    val fetchDiscoverTvShow: Flow<List<ResultTvShow>> = flow {
        while (true) {
            val result = apiService.getDiscoverTvShow().results
            emit(result)
        }
    }

    fun fetchTvShowDetail(id: Int): Flow<TvShowDetail> = flow {
        val result = apiService.getDetailsTvShowById(id)
        emit(result)
    }

    fun searchTvShow(movieName :String): Flow<List<ResultTvShow>> = flow {
        val result = apiService.searchTv(movieName).results
        emit(result)
    }

}