package com.oliva.marc.sesion5oruna.model.interactor.impl

import android.app.Application
import com.oliva.marc.sesion5oruna.model.interactor.MoviesInteractor
import com.oliva.marc.sesion5oruna.model.repository.firebase.MovieFB
import com.oliva.marc.sesion5oruna.model.repository.impl.MoviesRepositoryImpl
import com.oliva.marc.sesion5oruna.presenter.MoviePresenter

class MoviesInteractorImpl(moviePresenter: MoviePresenter, val application : Application) :
    MoviesInteractor {

    private var moviesRespository =
        MoviesRepositoryImpl(
            moviePresenter, application
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