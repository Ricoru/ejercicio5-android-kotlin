package com.oliva.marc.sesion5oruna.model.repository.api


import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface MoviesService {
    @GET("movie")
    fun listMovies():Call<JsonObject>
}