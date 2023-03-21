package com.example.practica1android.database

import androidx.room.Embedded
import androidx.room.Relation

data class DetalleComanda(
    @Embedded
    val comanda : Comanda,

    @Relation(parentColumn = "comandaId", entityColumn = "ordenComandaId")
    val orden: List<Orden>
)
