package com.oliva.marc.sesion5oruna.model.repository.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movie")
data class MovieEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "key")
    var key: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "picture")
    var picture: String,
    @ColumnInfo(name = "rating")
    var rating: String?,
    @ColumnInfo(name = "category")
    var category: String?
): Serializable