package com.oliva.marc.sesion5oruna.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.oliva.marc.sesion5oruna.R
import com.oliva.marc.sesion5oruna.model.Movie
import com.oliva.marc.sesion5oruna.model.repository.firebase.MovieFB
import com.oliva.marc.sesion5oruna.presenter.MoviePresenter
import com.oliva.marc.sesion5oruna.presenter.MoviePresenterImpl
import com.oliva.marc.sesion5oruna.view.adapter.MovieFBRecyclerAdapter
import com.oliva.marc.sesion5oruna.view.adapter.MovieRecyclerAdapter
import com.oliva.marc.sesion5oruna.view.util.message
import com.oliva.marc.sesion5oruna.view.util.startActivitiesResult
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MovieView {

    val REQUEST_REGISTER_MOVIE: Int = 1000

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
            MoviePresenterImpl(this, application)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add -> {
                startActivitiesResult(RegisterActivity::class.java, null, REQUEST_REGISTER_MOVIE)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showMoviesFB(movies: ArrayList<MovieFB>?) {
        try {
            if (movies?.isNotEmpty()!!) {
                movieAdapterFB = MovieFBRecyclerAdapter(movies, this)
                movies_recyclerview.adapter = movieAdapterFB
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getMovies() {
        moviePresenter?.getMovies()
    }

    override fun getMoviesFirestore() {
        moviePresenter?.getMoviesFirestore()
    }

    override fun success(msg: String) {
        message(msg)
        getMoviesFirestore()
    }

    override fun error(e: Throwable) {
        message(e.message!!)
    }

    override fun removeMovieFB(key: String) {
        moviePresenter?.removeMovieFB(key)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_REGISTER_MOVIE) {
            if (resultCode == Activity.RESULT_OK) {
                data.let {
                    val movie = MovieFB()
                    movie.name = data?.getStringExtra("name")!!
                    movie.category = data.getStringExtra("category")!!
                    movie.rating = data.getFloatExtra("rating", 0f).toString()
                    movie.picture = data.getStringExtra("picture")!!
                    moviePresenter?.addMovieFB(movie)
                }
            }
        }
    }

}
