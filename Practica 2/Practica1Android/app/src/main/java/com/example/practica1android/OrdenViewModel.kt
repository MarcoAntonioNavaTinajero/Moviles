package com.example.practica1android

import android.util.Log
import androidx.lifecycle.*

class OrdenViewModel : ViewModel() {

    private val _orden = MutableLiveData<MutableList<String>>()
    private val orden : LiveData<MutableList<String>> get() =_orden
    private val _contador = MutableLiveData(0)
    private val contador : LiveData<Int> get() = _contador

    init {
        _orden.value = mutableListOf<String>()
        Log.i("OrdenViewModel", "Se ha creado un OrdenViewModel")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("OrdenViewModel", "Se ha destruido el objeto OrdenViewModel")
    }

    fun addOrden(string: String){
        _orden.value?.add(string)
    }

    fun getOrden(): List<String>? {
        return orden.value
    }

    fun incrementar() {
        _contador.value = _contador.value?.plus(1)
    }

    fun observarContador(owner: LifecycleOwner, o: Observer<Int>) {
        _contador.observe(owner, o)
    }

    fun getContador(): Int {
        return contador.value!!
    }
}