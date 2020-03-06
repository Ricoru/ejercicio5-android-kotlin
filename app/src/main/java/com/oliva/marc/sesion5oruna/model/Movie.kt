package com.oliva.marc.sesion5oruna.model

import com.google.gson.JsonObject
import java.io.Serializable

open class Movie(movieJson: JsonObject?) : Serializable {

    init {

    }

    lateinit var name: String
    lateinit var picture: String
    lateinit var category: String
    var rating: Int = 0

    init {
        try {
            name = movieJson?.get(NAME)!!.asString
            picture = movieJson?.get(PICTURE)!!.asString
            category = movieJson?.get(CATEGORY)!!.asString
            rating = movieJson?.get(RATING)!!.asInt
        } catch (e: Exception) {

        }
    }

    companion object {
        private val NAME = "name"
        private val PICTURE = "picture"
        private val CATEGORY = "category"
        private val RATING = "rating"
    }
}