package com.oliva.marc.sesion5oruna.model.repository.db

import android.content.Context
import android.os.AsyncTask

class DBRoomRepository(context: Context?) {

    private var movieDao: MovieDao?

    init {
        val db = AppDataBase.getInstance(context)
        movieDao = db?.movieDao()
    }

    fun deleteAll() {
        movieDao.let {
            DeleteAllAsyncTask(movieDao).execute()
        }
    }

    fun addMovies(movies: List<MovieEntity>) {
        movieDao.let {
            InsertBatchAsyncTask(movieDao).execute(movies)
        }
    }

    private class InsertBatchAsyncTask internal constructor(
        private val mAsyncTaskDao: MovieDao?
    ) : AsyncTask<List<MovieEntity>, Void, Boolean>() {
        override fun doInBackground(vararg params: List<MovieEntity>): Boolean? {
            mAsyncTaskDao?.addBatch(params[0])
            return true
        }
    }

    private class DeleteAllAsyncTask internal constructor(
        private val mAsyncTaskDao: MovieDao?
    ) : AsyncTask<Void, Void, Boolean>() {
        override fun doInBackground(vararg p0: Void?): Boolean {
            mAsyncTaskDao?.truncate()
            return true
        }
    }

}