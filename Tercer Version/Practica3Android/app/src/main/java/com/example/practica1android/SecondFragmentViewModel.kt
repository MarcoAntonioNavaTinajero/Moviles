package com.example.practica1android

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.practica1android.database.Comanda
import com.example.practica1android.database.Orden
import com.example.practica1android.database.OrdenDatabaseDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SecondFragmentViewModel(ordenA: Array<String>, val database: OrdenDatabaseDAO, application: Application) : AndroidViewModel(application) {
    private val _orden = MutableLiveData<List<String>>()
    private val orden : LiveData<List<String>> get() = _orden
    private val orden_total = ordenA

    private var _orden_mutable = MutableLiveData<Orden?>()

    val orden_mutable: MutableLiveData<Orden?> get() = _orden_mutable

    fun doneNavigating() {
        _orden_mutable.value = null
    }

    init {
        _orden.value = ordenA.toList()
        Log.i("SecondFragmentViewModel", "Final array is...")
        for (i in ordenA){
            Log.i("SecondFragmentViewModel", "$ordenA")
        }
//        initializeComanda()
    }

    fun getOrden(): List<String>? {
        return orden.value
    }

//    private fun initializeComanda() {
//        viewModelScope.launch {
//            comanda.value = getComandaFromDataBase()
//        }
//    }
//
//    private suspend fun getComandaFromDataBase(): Comanda? {
//        var comanda = database
//    }

    fun starOrden() {
        CoroutineScope(Dispatchers.IO).launch {

            val newComanda = Comanda()
            val comandaid = newComanda.comandaId
            var orden_completa = orden_total
            var plat: String = ""
            for ( i in orden_completa) {
                plat =  "\n" + plat + i
            }
            val newOrden = Orden(ordenComandaId = comandaid, platillo = plat, cantidad = 1 , precio = 15.23)

            insert(newComanda, newOrden)
            _orden_mutable.postValue(newOrden)

        }
    }

    private suspend fun insert(comanda: Comanda, orden: Orden) {
        database.insert(comanda, orden)
    }
}

class SecondFragmentViewModelFactory(private val ordenA: Array<String>,
                                     private val dataSource: OrdenDatabaseDAO,
                                     private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SecondFragmentViewModel::class.java)){
            return SecondFragmentViewModel(ordenA, dataSource, application) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
        }
    }
