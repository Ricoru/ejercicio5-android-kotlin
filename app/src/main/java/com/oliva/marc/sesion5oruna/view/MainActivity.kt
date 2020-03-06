package com.oliva.marc.sesion5oruna.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.oliva.marc.sesion5oruna.R
import com.oliva.marc.sesion5oruna.model.Movie
import com.oliva.marc.sesion5oruna.model.repository.firebase.MovieFB
import com.oliva.marc.sesion5oruna.presenter.MoviePresenter
import com.oliva.marc.sesion5oruna.presenter.MoviePresenterImpl
import com.oliva.marc.sesion5oruna.view.adapter.MovieFBRecyclerAdapter
import com.oliva.marc.sesion5oruna.view.adapter.MovieRecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    MovieView {

    private var moviePresenter: MoviePresenter? = null
    lateinit var movieAdapter: MovieRecyclerAdapter
    lateinit var movieAdapterFB: MovieFBRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpInstances()
        ui()
    }

    fun ui() {
        //getMovies()
        getMoviesFirestore()
    }

    fun setUpInstances() {
        moviePresenter =
            MoviePresenterImpl(this)
    }

    override fun showMovies(movies: ArrayList<Movie>?) {
        try {
            if (movies?.isNotEmpty()!!) {
                movieAdapter = MovieRecyclerAdapter(movies)
                movies_recyclerview.adapter = movieAdapter
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun showMoviesFB(movies: ArrayList<MovieFB>?) {
        try {
            if (movies?.isNotEmpty()!!) {
                movieAdapterFB = MovieFBRecyclerAdapter(movies)
                movies_recyclerview.adapter = movieAdapterFB
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getMovies() {
        Log.i("INFO", "getMovies ")
        moviePresenter?.getMovies()
    }

    override fun getMoviesFirestore() {
        moviePresenter?.getMoviesFirestore()
    }
}
