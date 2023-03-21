package com.example.practica1android

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.practica1android.database.OrdenDatabaseDAO

class CompraViewModel(
        val database: OrdenDatabaseDAO,
        application: Application) : AndroidViewModel(application) {
}