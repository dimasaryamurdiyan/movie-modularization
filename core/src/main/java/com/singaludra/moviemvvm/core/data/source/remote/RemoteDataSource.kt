package com.singaludra.moviemvvm.core.data.source.remote

import android.util.Log
import com.singaludra.moviemvvm.core.data.source.remote.network.ApiResponse
import com.singaludra.moviemvvm.core.data.source.remote.network.ApiService
import com.singaludra.moviemvvm.core.data.source.remote.response.GetListMovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getAllTourism(): Flow<ApiResponse<List<GetListMovieResponse.MovieResponse?>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getListMovie()
                val dataArray = response.results
                if (dataArray?.isNotEmpty( )== true){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}