package com.oliva.marc.sesion5oruna.model.repository.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.oliva.marc.sesion5oruna.presenter.MoviePresenter

class FirebaseMoviesService(val moviePresenter: MoviePresenter) : FirebaseMovie {

    companion object {
        private const val MOVIES_COLLECTION = "movies"
        private const val MOVIES_FIELD_NAME = "name"
        private const val MOVIES_FIELD_PICTURE = "picture"
        private const val MOVIES_FIELD_RATING = "rating"
        private const val MOVIES_FIELD_CATEGORY = "category"
    }

    private val remoteDB = FirebaseFirestore.getInstance().apply {
        firestoreSettings = FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(false)
            .build()
    }

    override fun getAllMovies() {
        val movies = ArrayList<MovieFB>()
        remoteDB.collection(MOVIES_COLLECTION)
            .get()
            .addOnSuccessListener {
                for (e in it.documents) {
                    val result = e.toObject(MovieFB::class.java)
                    movies.add(result!!)
                }
                moviePresenter.showMoviesFB(movies)
            }
            .addOnFailureListener {
                moviePresenter.error(it)
            }
    }

    override fun addMovie(movie: MovieFB) {
        val movieData = HashMap<String, Any>()
        movieData[MOVIES_FIELD_NAME] = movie.name
        movieData[MOVIES_FIELD_PICTURE] = movie.picture
        movieData[MOVIES_FIELD_RATING] = movie.rating
        movieData[MOVIES_FIELD_CATEGORY] = movie.category

        remoteDB.collection(MOVIES_COLLECTION)
            .add(movieData)
            .addOnSuccessListener {

            }
            .addOnFailureListener {

            }
    }

    override fun deleteMovie(movieId: String) {
        remoteDB.collection(MOVIES_COLLECTION)
            .document(movieId)
            .delete()
            .addOnSuccessListener {
            }
            .addOnFailureListener {
            }
    }

}