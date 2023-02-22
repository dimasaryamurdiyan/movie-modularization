package com.singaludra.moviemvvm.core.data.source.remote.network

import com.singaludra.moviemvvm.core.data.source.remote.response.GetListMovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("/movie/popular")
    suspend fun getListMovie(): GetListMovieResponse
}