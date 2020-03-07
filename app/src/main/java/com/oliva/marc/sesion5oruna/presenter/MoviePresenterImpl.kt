package com.oliva.marc.sesion5oruna.presenter

import com.oliva.marc.sesion5oruna.model.Movie
import com.oliva.marc.sesion5oruna.model.interactor.MoviesInteractor
import com.oliva.marc.sesion5oruna.model.interactor.impl.MoviesInteractorImpl
import com.oliva.marc.sesion5oruna.model.repository.firebase.MovieFB
import com.oliva.marc.sesion5oruna.view.MovieView

class MoviePresenterImpl(val moviesView: MovieView) : MoviePresenter {

    private val movieInteractor: MoviesInteractor =
        MoviesInteractorImpl(
            this
        )

    override fun showMovies(movies: ArrayList<Movie>?) {
        moviesView.showMovies(movies)
    }

    override fun showMoviesFB(movies: ArrayList<MovieFB>?) {
        moviesView.showMoviesFB(movies)
    }

    override fun removeMovieFB(key: String) {
        movieInteractor.removeMovieFB(key)
    }

    override fun addMovieFB(movie: MovieFB) {
        movieInteractor.addMoviewFB(movie)
    }

    override fun getMovies() {
        movieInteractor.getMoviesAPI()
    }

    override fun getMoviesFirestore() {
        movieInteractor.getMoviesFirestore()
    }

    override fun success(msg: String) {
        moviesView.success(msg)
    }

    override fun error(err: Throwable) {
        moviesView.error(err)
    }

}