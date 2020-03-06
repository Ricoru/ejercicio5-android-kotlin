package com.oliva.marc.sesion5oruna.model.interactor.impl

import android.util.Log
import com.oliva.marc.sesion5oruna.model.interactor.MoviesInteractor
import com.oliva.marc.sesion5oruna.model.repository.impl.MoviesRepositoryImpl
import com.oliva.marc.sesion5oruna.presenter.MoviePresenter

class MoviesInteractorImpl(moviePresenter: MoviePresenter) :
    MoviesInteractor {
    private var moviesRespository =
        MoviesRepositoryImpl(
            moviePresenter
        )
    override fun getMoviesAPI() {
        Log.i("INFO", "MoviesInteractorImpl::getMoviesAPI")
        moviesRespository.getMoviesAPI()
    }

    override fun getMoviesFirestore() {
        moviesRespository.getMoviesFirestore()
    }

}