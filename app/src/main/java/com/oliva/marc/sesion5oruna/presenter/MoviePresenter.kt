package com.oliva.marc.sesion5oruna.presenter

import com.oliva.marc.sesion5oruna.model.Movie
import com.oliva.marc.sesion5oruna.model.repository.firebase.MovieFB

interface MoviePresenter {
    fun showMovies(movies: ArrayList<Movie>?)
    fun getMovies()
    fun getMoviesFirestore()

    fun showMoviesFB(movies: ArrayList<MovieFB>?)
    fun removeMovieFB(key: String)
    fun addMovieFB(movie: MovieFB)

    fun success(msg : String)
    fun error(err: Throwable)
}