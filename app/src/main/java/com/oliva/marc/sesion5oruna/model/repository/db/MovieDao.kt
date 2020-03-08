package com.oliva.marc.sesion5oruna.model.repository.db

import androidx.room.Query

@androidx.room.Dao
interface MovieDao : Dao<MovieEntity> {

    @Query("delete from movie")
    fun truncate()

    @Query("select * from movie")
    fun getAll(): List<MovieEntity>
}