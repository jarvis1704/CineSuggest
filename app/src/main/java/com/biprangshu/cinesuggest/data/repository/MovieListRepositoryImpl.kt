package com.biprangshu.cinesuggest.data.repository

import coil.network.HttpException
import com.biprangshu.cinesuggest.data.local.MovieDatabase
import com.biprangshu.cinesuggest.data.mapper.toMovie
import com.biprangshu.cinesuggest.data.mapper.toMovieEntity
import com.biprangshu.cinesuggest.data.remote.MovieApi
import com.biprangshu.cinesuggest.domain.model.Movie
import com.biprangshu.cinesuggest.domain.repository.MovieListRepository
import com.biprangshu.cinesuggest.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val api: MovieApi,
    private val movieDatabase: MovieDatabase
): MovieListRepository {

    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>>{
        return flow {
            emit(Resource.Loading(true))
            val localMovieList = movieDatabase.movieDao.getMovieListByCategory(category)
            val shouldLoadLocalMovie= localMovieList.isNotEmpty() && !forceFetchFromRemote

            if(shouldLoadLocalMovie){
                emit(Resource.Success(
                    data = localMovieList.map {
                        movieEntity ->
                        movieEntity.toMovie(category)
                    }
                ))

                emit(Resource.Loading(false))
                return@flow
            }

            val movieListFromApi=try {
                api.getMoviesList(category, page)
            } catch (e: IOException){
                e.printStackTrace()
                emit(Resource.Error("Couldn't load Movies, Make sure you are connected to Internet"))
                return@flow
            } catch (e: HttpException){
                e.printStackTrace()
                emit(Resource.Error("Couldn't load Movies, Make sure you are connected to Internet"))
                return@flow
            } catch (e: Exception){
                e.printStackTrace()
                emit(Resource.Error("Couldn't load Movies, Make sure you are connected to Internet"))
                return@flow
            }

            val movieEntities=movieListFromApi.results.let {
                it.map { movieDto ->
                    movieDto.toMovieEntity(category)
                }
            }

            movieDatabase.movieDao.upsertAll(movieEntities)

            emit(Resource.Success(
                data = movieEntities.map {
                    movieEntity ->
                    movieEntity.toMovie(category)
                }
            ))
            emit(Resource.Loading(false))


        }
    }

    override suspend fun getMovie(id: Int): Flow<Resource<Movie>> {
        return flow {
            emit(Resource.Loading(true))

            val movieEntity= movieDatabase.movieDao.getMovieById(id)
            if(movieEntity!=null){
                emit(Resource.Success(
                    data = movieEntity.toMovie(movieEntity.category)
                ))
                emit(Resource.Loading(false))
                return@flow
            }

            emit(Resource.Error("You this this movie Exists? Maybe a Typo"))

            emit(Resource.Loading(false))


        }
    }

}