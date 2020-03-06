package com.oliva.marc.sesion5oruna.model.repository.firebase

interface FirebaseMovie {
    fun getAllMovies()
            //: List<MovieFB>
    fun addMovie(movie: MovieFB)
    fun deleteMovie(movieId: String)

}