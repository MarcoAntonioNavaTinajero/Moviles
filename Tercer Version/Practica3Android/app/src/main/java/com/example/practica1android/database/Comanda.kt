package com.example.practica1android.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "comanda")
data class Comanda(
    @PrimaryKey(autoGenerate = true)
    var comandaId: Long = 0L,

    @ColumnInfo(name = "diahora")
    var diahora: String = LocalDateTime.now().toString()
)
