package com.oliva.marc.sesion5oruna.model.repository.db

import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(item: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addBatch(item: List<T>)

    @Delete
    fun delete(item:T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(item: T)

}