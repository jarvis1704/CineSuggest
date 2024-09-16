package com.biprangshu.cinesuggest.data.local

import androidx.room.Dao
import androidx.room.Upsert
import retrofit2.http.Query

@Dao
interface MovieDao{
    @Upsert
    suspend fun upsertAll(moviesList: List<MovieEntity>)

    @Query("SELECT * FROM MovieEntity WHERE id= :id")
    suspend fun getMovieById(id: Int): MovieEntity

    @Query("SELECT * FROM MovieEntity WHERE category= :category")
    suspend fun getMovieListByCategory(category: String): List<MovieEntity>
}
