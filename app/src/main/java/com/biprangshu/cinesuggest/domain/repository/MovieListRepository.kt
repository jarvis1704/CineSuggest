package com.biprangshu.cinesuggest.domain.repository

import com.biprangshu.cinesuggest.domain.model.Movie
import com.biprangshu.cinesuggest.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {

    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>>

    suspend fun getMovie(
        id: Int
    ): Flow<Resource<Movie>>

}