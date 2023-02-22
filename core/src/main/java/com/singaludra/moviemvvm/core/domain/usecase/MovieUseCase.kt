package com.singaludra.moviemvvm.core.domain.usecase

import com.dicoding.tourismapp.core.data.Resource
import com.singaludra.moviemvvm.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovie(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)
}