package com.biprangshu.cinesuggest.presentation

sealed interface MovieListUiEvent {

    data class Pagenate(val category: String): MovieListUiEvent
    object Navigate: MovieListUiEvent
}