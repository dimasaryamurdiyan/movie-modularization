package com.singaludra.moviemvvm.core.utils

import com.singaludra.moviemvvm.core.data.source.local.entity.MovieEntity
import com.singaludra.moviemvvm.core.data.source.remote.response.GetListMovieResponse
import com.singaludra.moviemvvm.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<GetListMovieResponse.MovieResponse>): List<MovieEntity>{
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                id = it.id!!,
                adult = it.adult!!,
                backdropPath = it.backdropPath!!,
                genreIds = it.genreIds!!,
                originalLanguage = it.originalLanguage!!,
                originalTitle = it.originalTitle!!,
                overview = it.overview!!,
                popularity = it.popularity!!,
                posterPath = it.posterPath!!,
                releaseDate = it.releaseDate!!,
                title = it.title!!,
                video = it.video!!,
                voteAverage = it.voteAverage!!,
                voteCount = it.voteCount!!,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
           Movie(
                id = it.id!!,
                adult = it.adult!!,
                backdropPath = it.backdropPath!!,
                genreIds = it.genreIds!!,
                originalLanguage = it.originalLanguage!!,
                originalTitle = it.originalTitle!!,
                overview = it.overview!!,
                popularity = it.popularity!!,
                posterPath = it.posterPath!!,
                releaseDate = it.releaseDate!!,
                title = it.title!!,
                video = it.video!!,
                voteAverage = it.voteAverage!!,
                voteCount = it.voteCount!!,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainEntity(input: Movie) =
        MovieEntity(
            id = input.id!!,
            adult = input.adult!!,
            backdropPath = input.backdropPath!!,
            genreIds = input.genreIds!!,
            originalLanguage = input.originalLanguage!!,
            originalTitle = input.originalTitle!!,
            overview = input.overview!!,
            popularity = input.popularity!!,
            posterPath = input.posterPath!!,
            releaseDate = input.releaseDate!!,
            title = input.title!!,
            video = input.video!!,
            voteAverage = input.voteAverage!!,
            voteCount = input.voteCount!!,
            isFavorite = input.isFavorite
        )


}