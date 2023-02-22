package com.singaludra.moviemvvm.core.data.source.remote.response
import android.os.Parcelable

import kotlinx.parcelize.Parcelize

import com.google.gson.annotations.SerializedName


@Parcelize
data class GetListMovieResponse(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: List<MovieResponse?>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
) : Parcelable {
    @Parcelize
    data class MovieResponse(
        @SerializedName("adult")
        val adult: Boolean? = null,
        @SerializedName("backdrop_path")
        val backdropPath: String? = null,
        @SerializedName("genre_ids")
        val genreIds: List<Int?>? = null,
        @SerializedName("id")
        val id: Int? = null,
        @SerializedName("original_language")
        val originalLanguage: String? = null,
        @SerializedName("original_title")
        val originalTitle: String? = null,
        @SerializedName("overview")
        val overview: String? = null,
        @SerializedName("popularity")
        val popularity: Double? = null,
        @SerializedName("poster_path")
        val posterPath: String? = null,
        @SerializedName("release_date")
        val releaseDate: String? = null,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("video")
        val video: Boolean? = null,
        @SerializedName("vote_average")
        val voteAverage: Double? = null,
        @SerializedName("vote_count")
        val voteCount: Int? = null
    ) : Parcelable
}