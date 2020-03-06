package com.oliva.marc.sesion5oruna.view

import com.oliva.marc.sesion5oruna.model.Movie
import com.oliva.marc.sesion5oruna.model.repository.firebase.MovieFB

interface MovieView {
    fun showMovies(movies: ArrayList<Movie>?)
    fun showMoviesFB(movies: ArrayList<MovieFB>?)
    fun getMovies()
    fun getMoviesFirestore()
}