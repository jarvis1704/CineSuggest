package com.biprangshu.cinesuggest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biprangshu.cinesuggest.domain.repository.MovieListRepository
import com.biprangshu.cinesuggest.utils.Category
import com.biprangshu.cinesuggest.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieLIstViewModel @Inject constructor(
    private val movieListRepository: MovieListRepository
): ViewModel() {

    private val _movieListState= MutableStateFlow(MovieListState())

    val movieListState= _movieListState.asStateFlow()

    init {
        getPopularMoviesList(false)
        getUpcomingMoviesList(false)
    }

    fun onEvent(event: MovieListUiEvent){
        when(event){
            MovieListUiEvent.Navigate -> {
                _movieListState.update {
                    it.copy(
                        isCurrentPopularScreen = !movieListState.value.isCurrentPopularScreen
                    )
                }
            }
            is MovieListUiEvent.Pagenate -> {
                if(event.category==Category.POPULAR){
                    getPopularMoviesList(true)
                } else if (event.category==Category.UPCOMING){
                    getUpcomingMoviesList(true)
                }
            }
        }
    }

    private fun getUpcomingMoviesList(forceFetchFromRemote: Boolean) {
        viewModelScope.launch{
            _movieListState.update {
                it.copy(isLoading = true)
            }

            movieListRepository.getMovieList(
                forceFetchFromRemote,
                Category.UPCOMING,
                movieListState.value.popularMovieListPage
            ).collectLatest {
                    result->
                when(result){
                    is Resource.Error -> {
                        _movieListState.update{
                            it.copy(isLoading = false)
                        }
                    }

                    is Resource.Loading -> {
                        _movieListState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }
                    is Resource.Success -> {
                        result.data?.let{
                                upcomingMovieList->
                            _movieListState.update {
                                it.copy(
                                    upcomingMovieList = movieListState.value.upcomingMovieList + upcomingMovieList.shuffled(),
                                    upcomingMovieListPage = movieListState.value.upcomingMovieListPage + 1
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun getPopularMoviesList(forceFetchFromRemote: Boolean) {
        viewModelScope.launch{
            _movieListState.update {
                it.copy(isLoading = true)
            }

            movieListRepository.getMovieList(
                forceFetchFromRemote,
                Category.POPULAR,
                movieListState.value.popularMovieListPage
            ).collectLatest {
                result->
                when(result){
                    is Resource.Error -> {
                        _movieListState.update{
                            it.copy(isLoading = false)
                        }
                    }

                    is Resource.Loading -> {
                        _movieListState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }
                    is Resource.Success -> {
                        result.data?.let{
                            popularMovieList->
                            _movieListState.update {
                                it.copy(
                                    popularMovieList = movieListState.value.popularMovieList + popularMovieList.shuffled(),
                                    popularMovieListPage = movieListState.value.popularMovieListPage + 1
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}