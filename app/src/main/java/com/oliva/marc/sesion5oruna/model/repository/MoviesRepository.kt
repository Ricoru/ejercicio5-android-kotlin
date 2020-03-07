package com.oliva.marc.sesion5oruna.model.repository

import com.oliva.marc.sesion5oruna.model.repository.firebase.MovieFB

interface MoviesRepository {
    fun getMoviesAPI()
    fun getMoviesFirestore()

    fun addMovieFirestore(moview : MovieFB)
    fun removeMovieFirestore(key : String)
}