package com.example.practica1android.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orden")
data class Orden(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "orden_id")
    val ordenId: Long = 0L,

    @ColumnInfo(name = "ordencomandaid")
    val ordenComandaId: Long,

    @ColumnInfo(name = "platillo")
    val platillo: String,

    @ColumnInfo(name = "cantidad")
    val cantidad: Int = 0,

    @ColumnInfo(name = "precio")
    val precio: Double = 0.0,


)
