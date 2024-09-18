package com.biprangshu.cinesuggest.details

import com.biprangshu.cinesuggest.domain.model.Movie

data class DetailsState(
    val isLoading: Boolean = false,
    val movie: Movie? = null,

)
