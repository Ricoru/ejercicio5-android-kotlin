package com.oliva.marc.sesion5oruna.model.repository.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ReferenceMoviesService {
    val urlApi = "https://app-mobile-movies.herokuapp.com/api/"
    fun getClientService(): MoviesService {
        val retrofit = Retrofit.Builder()
            .baseUrl(urlApi)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(MoviesService::class.java)
    }
}