package com.biprangshu.cinesuggest.presentation

import com.biprangshu.cinesuggest.domain.model.Movie

data class MovieListState(
    val isLoading: Boolean = false,
    val popularMovieListPage: Int= 1,
    val upcomingMovieListPage: Int= 1,
    val isCurrentPopularScreen: Boolean= true,

    val popularMovieList: List<Movie> = emptyList(),
    val upcomingMovieList: List<Movie> = emptyList()
)
