package com.oliva.marc.sesion5oruna.model.interactor.impl

import com.oliva.marc.sesion5oruna.model.interactor.MoviesInteractor
import com.oliva.marc.sesion5oruna.model.repository.firebase.MovieFB
import com.oliva.marc.sesion5oruna.model.repository.impl.MoviesRepositoryImpl
import com.oliva.marc.sesion5oruna.presenter.MoviePresenter

class MoviesInteractorImpl(moviePresenter: MoviePresenter) :
    MoviesInteractor {

    private var moviesRespository =
        MoviesRepositoryImpl(
            moviePresenter
        )

    override fun getMoviesAPI() {
        moviesRespository.getMoviesAPI()
    }

    override fun getMoviesFirestore() {
        moviesRespository.getMoviesFirestore()
    }

    override fun addMoviewFB(movie: MovieFB) {
        moviesRespository.addMovieFirestore(movie)
    }

    override fun removeMovieFB(key: String) {
        moviesRespository.removeMovieFirestore(key)
    }

}