package com.example.practica1android.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface OrdenDatabaseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(comanda: Comanda, orden:Orden)

    @Update
    fun update(orden: Orden)

    @Query("SELECT * FROM orden ORDER BY orden_id DESC LIMIT 1")
    fun getFirst(): List<Orden>

    @Transaction
    @Query("SELECT * FROM orden WHERE ordencomandaid = :comandaid")
    fun getDetalleComanda(comandaid: Long): List<Orden>
}