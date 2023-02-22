package com.singaludra.moviemvvm.core.domain.repository

import com.dicoding.tourismapp.core.data.Resource
import com.singaludra.moviemvvm.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getAllMovie(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)
}