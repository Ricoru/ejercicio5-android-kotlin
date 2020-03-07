package com.oliva.marc.sesion5oruna.model.interactor

import com.oliva.marc.sesion5oruna.model.repository.firebase.MovieFB

interface MoviesInteractor {
    fun getMoviesAPI()
    fun getMoviesFirestore()

    fun addMoviewFB(movie : MovieFB)
    fun removeMovieFB(key: String)
}