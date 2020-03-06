package com.oliva.marc.sesion5oruna.presenter

import com.oliva.marc.sesion5oruna.model.Movie
import com.oliva.marc.sesion5oruna.model.repository.firebase.MovieFB

interface MoviePresenter {
    fun showMovies(movies: ArrayList<Movie>?)
    fun showMoviesFB(movies: ArrayList<MovieFB>?)
    fun getMovies()
    fun getMoviesFirestore()

    fun error(err : Throwable)
}