package com.oliva.marc.sesion5oruna.presenter

import com.oliva.marc.sesion5oruna.model.Movie
import com.oliva.marc.sesion5oruna.model.interactor.MoviesInteractor
import com.oliva.marc.sesion5oruna.model.interactor.impl.MoviesInteractorImpl
import com.oliva.marc.sesion5oruna.model.repository.firebase.MovieFB
import com.oliva.marc.sesion5oruna.view.MovieView

class MoviePresenterImpl(val moviesView: MovieView) :
    MoviePresenter {

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

    override fun getMovies() {
        movieInteractor.getMoviesAPI()
    }

    override fun getMoviesFirestore() {
        movieInteractor.getMoviesFirestore()
    }

    override fun error(err: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}