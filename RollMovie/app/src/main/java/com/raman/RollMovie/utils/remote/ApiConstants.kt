package com.raman.RollMovie.utils.remote

internal object ApiConstants {

    internal const val API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4Yzk3MTIyNjhhOGI4MGY3ODk1YjkxMjA0NDE0ZWFlMyIsInN1YiI6IjY1NjRmYjY3ZDk1NTRiMDEzYWYyZjkzYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.cyHECSIuqc3brVDivHRZVJ9_Tt9P3RZoQMeB4QM1MRU"
    internal const val BASE_URL = "https://api.themoviedb.org/3/"
    internal const val IMAGE_URL = "https://image.tmdb.org/t/p/w500"

    internal const val MOVIE = "movie"
    internal const val TV_SHOW = "tvShow"

    internal const val UPCOMING_MOVIE = "movie/upcoming"
    internal const val TOP_RATED_MOVIE = "movie/top_rated"
    internal const val POPULAR_MOVIE = "movie/popular"
    internal const val NOW_PLAYING_MOVIE = "movie/now_playing"
    internal const val DISCOVER_MOVIE = "discover/movie"
    internal const val TRENDING_MOVIE = "trending/movie/day"
    internal const val DETAILS_MOVIE = "movie/{id}"
    internal const val SEARCH_MOVIE = "search/movie"

    internal const val TOP_RATED_TV_SHOW = "tv/top_rated"
    internal const val POPULAR_TV_SHOW = "tv/popular"
    internal const val ON_THE_AIR_TV_SHOW = "tv/on_the_air"
    internal const val DISCOVER_TV_SHOW = "discover/tv"
    internal const val TRENDING_TV_SHOW = "trending/tv/day"
    internal const val DETAILS_TV_SHOW = "tv/{id}"
    internal const val SEARCH_TV_SHOW = "search/tv"

    internal const val PAGE = "page"
    internal const val DEFAULT_PAGE = 1
    internal const val ID = "id"
    internal const val QUERY = "query"
    private const val CREDITS = "credits"
    internal const val APPEND_TO_RESPONSE = "append_to_response"

    internal val DETAILS_APPEND_TO_RESPONSE = buildAppendToResponse(CREDITS)

    private fun buildAppendToResponse(vararg fields: String) =
        fields.joinToString(separator = APPEND_TO_RESPONSE_SEPARATOR)

    private const val APPEND_TO_RESPONSE_SEPARATOR = ","

    internal object Utils {

        internal const val IMAGE_URL_TEST = "https://upload.wikimedia.org/wikipedia/commons/3/36/Hopetoun_falls.jpg"

    }

    internal object AppScreen {
        internal const val KEY_DETAIL_ARG = "detail_screen"
        internal const val KEY_DETAIL_TYPE_ARG = "detail_screen_type"
    }

}