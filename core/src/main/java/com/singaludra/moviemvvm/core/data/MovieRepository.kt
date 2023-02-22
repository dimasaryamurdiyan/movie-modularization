package com.singaludra.moviemvvm.core.data

import com.dicoding.tourismapp.core.data.NetworkBoundResource
import com.dicoding.tourismapp.core.data.Resource
import com.singaludra.moviemvvm.core.data.source.local.LocalDataSource
import com.singaludra.moviemvvm.core.data.source.remote.RemoteDataSource
import com.singaludra.moviemvvm.core.data.source.remote.network.ApiResponse
import com.singaludra.moviemvvm.core.data.source.remote.response.GetListMovieResponse
import com.singaludra.moviemvvm.core.domain.model.Movie
import com.singaludra.moviemvvm.core.domain.repository.IMovieRepository
import com.singaludra.moviemvvm.core.utils.AppExecutors
import com.singaludra.moviemvvm.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IMovieRepository {
    override fun getAllMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<GetListMovieResponse.MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovie().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<GetListMovieResponse.MovieResponse>>> {
                return remoteDataSource.getAllTourism() as Flow<ApiResponse<List<GetListMovieResponse.MovieResponse>>>
            }

            override suspend fun saveCallResult(data: List<GetListMovieResponse.MovieResponse>) {
                val movieList =  DataMapper.mapResponsesToEntities(data)
                localDataSource.insertmovie(movieList)
            }
        }.asFlow()

    override fun getFavoriteMovie(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovie().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
       val movieEntity = DataMapper.mapDomainEntity(movie)
        appExecutors.diskIO().execute{
            localDataSource.setFavoriteMovie(movieEntity, state)
        }
    }
}