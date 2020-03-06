package com.oliva.marc.sesion5oruna.model.repository.impl

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.oliva.marc.sesion5oruna.model.Movie
import com.oliva.marc.sesion5oruna.model.repository.MoviesRepository
import com.oliva.marc.sesion5oruna.model.repository.api.ReferenceMoviesService
import com.oliva.marc.sesion5oruna.model.repository.firebase.FirebaseMoviesService
import com.oliva.marc.sesion5oruna.presenter.MoviePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepositoryImpl(val moviePresenter: MoviePresenter) :
    MoviesRepository {

    override fun getMoviesAPI() {
        val movies: ArrayList<Movie>? = ArrayList()
        val apiAdapter =
            ReferenceMoviesService()
        val apiService = apiAdapter.getClientService()
        val call = apiService.listMovies()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val countriesJsonArray = response.body()?.getAsJsonArray("movies")

                countriesJsonArray?.forEach { jsonElement: JsonElement ->
                    val jsonObject = jsonElement.asJsonObject
                    val country =
                        Movie(jsonObject)
                    movies?.add(country)

                }

                moviePresenter.showMovies(movies)
            }
        })
    }

    override fun getMoviesFirestore() = FirebaseMoviesService(moviePresenter).getAllMovies()

}