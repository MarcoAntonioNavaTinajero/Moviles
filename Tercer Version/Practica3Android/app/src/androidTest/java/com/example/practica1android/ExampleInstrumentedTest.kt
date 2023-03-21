package com.example.practica1android

import androidx.room.Room
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.practica1android.database.Comanda
import com.example.practica1android.database.Orden
import com.example.practica1android.database.OrdenDatabaseDAO
import com.example.practica1android.database.PizzasDataBase
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class PizzasDatabaseTest {
    private lateinit var ordendatabaseDao: OrdenDatabaseDAO
    private lateinit var db: PizzasDataBase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, PizzasDataBase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        ordendatabaseDao = db.ordenDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetFirstOrden() {
        val comanda = Comanda()
        val orden = Orden(ordenComandaId = comanda.comandaId, platillo = "pepperoni", cantidad = 1, precio = 100.0)
        ordendatabaseDao.insert(comanda, orden)
        val reg = ordendatabaseDao.getFirst()
        assertEquals(reg.first().platillo, "pepperoni")
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetComandaDetalle() {
        val comanda = Comanda()
        var orden = Orden(ordenComandaId = comanda.comandaId, platillo = "4 quesos", cantidad = 1, precio = 100.0)
        ordendatabaseDao.insert(comanda, orden)
        orden = Orden(ordenComandaId = comanda.comandaId, platillo = "di mare", cantidad = 1, precio = 150.0)
        ordendatabaseDao.insert(comanda, orden)
        val reg = ordendatabaseDao.getDetalleComanda(comanda.comandaId)
        assertEquals(reg.size, 2)
    }
}
