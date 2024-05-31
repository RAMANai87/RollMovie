package com.raman.RollMovie.model.api

import com.raman.RollMovie.model.data.detail.movie.DetailResponse
import com.raman.RollMovie.model.data.detail.tv.TvShowDetail
import com.raman.RollMovie.model.data.movie.MovieResult
import com.raman.RollMovie.model.data.tv.TvResponse
import com.raman.RollMovie.utils.remote.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // Movies Api
    @GET(ApiConstants.POPULAR_MOVIE)
    suspend fun getPopularMovies(
        @Query(ApiConstants.PAGE) page: Int = ApiConstants.DEFAULT_PAGE
    ): MovieResult

    @GET(ApiConstants.NOW_PLAYING_MOVIE)
    suspend fun getNowPlayingMovies(
        @Query(ApiConstants.PAGE) page: Int = ApiConstants.DEFAULT_PAGE
    ): MovieResult

    @GET(ApiConstants.TOP_RATED_MOVIE)
    suspend fun getTopRatedMovies(
        @Query(ApiConstants.PAGE) page: Int = ApiConstants.DEFAULT_PAGE
    ): MovieResult

    @GET(ApiConstants.UPCOMING_MOVIE)
    suspend fun getUpcomingMovies(
        @Query(ApiConstants.PAGE) page: Int = ApiConstants.DEFAULT_PAGE
    ): MovieResult

    @GET(ApiConstants.DISCOVER_MOVIE)
    suspend fun getDiscoverMovies(
        @Query(ApiConstants.PAGE) page: Int = ApiConstants.DEFAULT_PAGE
    ): MovieResult

    @GET(ApiConstants.TRENDING_MOVIE)
    suspend fun getTrendingMovies(
        @Query(ApiConstants.PAGE) page: Int = ApiConstants.DEFAULT_PAGE
    ): MovieResult

    @GET(ApiConstants.DETAILS_MOVIE)
    suspend fun getDetailsMovieById(
        @Path(ApiConstants.ID)
        id: Int,
        @Query(ApiConstants.APPEND_TO_RESPONSE)
        appendToResponse: String = ApiConstants.DETAILS_APPEND_TO_RESPONSE
    ): DetailResponse

    @GET(ApiConstants.SEARCH_MOVIE)
    suspend fun searchMovie(
        @Query(ApiConstants.QUERY) query: String,
        @Query(ApiConstants.PAGE) page: Int = ApiConstants.DEFAULT_PAGE
    ): MovieResult

    // Tv Shows Api
    @GET(ApiConstants.TOP_RATED_TV_SHOW)
    suspend fun getTopRatedTvShow(
        @Query(ApiConstants.PAGE) page: Int = ApiConstants.DEFAULT_PAGE
    ): TvResponse

    @GET(ApiConstants.POPULAR_TV_SHOW)
    suspend fun getPopularTvShow(
        @Query(ApiConstants.PAGE) page: Int = ApiConstants.DEFAULT_PAGE
    ): TvResponse

    @GET(ApiConstants.ON_THE_AIR_TV_SHOW)
    suspend fun getOnTheAirTvShow(
        @Query(ApiConstants.PAGE) page: Int = ApiConstants.DEFAULT_PAGE
    ): TvResponse

    @GET(ApiConstants.DISCOVER_TV_SHOW)
    suspend fun getDiscoverTvShow(
        @Query(ApiConstants.PAGE) page: Int = ApiConstants.DEFAULT_PAGE
    ): TvResponse

    @GET(ApiConstants.TRENDING_TV_SHOW)
    suspend fun getTrendingTvShow(
        @Query(ApiConstants.PAGE) page: Int = ApiConstants.DEFAULT_PAGE
    ): TvResponse

    @GET(ApiConstants.DETAILS_TV_SHOW)
    suspend fun getDetailsTvShowById(
        @Path(ApiConstants.ID)
        id: Int,
        @Query(ApiConstants.APPEND_TO_RESPONSE)
        appendToResponse: String = ApiConstants.DETAILS_APPEND_TO_RESPONSE
    ): TvShowDetail

    @GET(ApiConstants.SEARCH_TV_SHOW)
    suspend fun searchTv(
        @Query(ApiConstants.QUERY) query: String,
        @Query(ApiConstants.PAGE) page: Int = ApiConstants.DEFAULT_PAGE
    ): TvResponse

}