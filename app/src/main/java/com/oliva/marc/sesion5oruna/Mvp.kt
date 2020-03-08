package com.oliva.marc.sesion5oruna

import android.app.Application
import com.oliva.marc.sesion5oruna.model.repository.db.DBRoomRepository

class Mvp : Application() {

    private lateinit var repository: DBRoomRepository

    override fun onCreate() {
        super.onCreate()
        repository = DBRoomRepository(this)
    }

    fun getMvpRepository(): DBRoomRepository {
        return repository
    }

}