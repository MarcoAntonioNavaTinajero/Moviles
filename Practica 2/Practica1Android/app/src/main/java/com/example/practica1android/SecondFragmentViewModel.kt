package com.example.practica1android

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SecondFragmentViewModel(ordenA: Array<String>) : ViewModel() {
    private val _orden = MutableLiveData<List<String>>()
    private val orden : LiveData<List<String>> get() = _orden

    init{
        _orden.value = ordenA.toList()
        Log.i("SecondFragmentViewModel","Final array is...")
        for(i in ordenA){
            Log.i("SecondFragmentViewModel index:    ,", "$ordenA")
        }
    }
    fun getOrden(): List<String>? {
        return orden.value
    }
}

class SecondFragmentViewModelFactory(private val ordenA: Array<String>) : ViewModelProvider.Factory{
    override fun<T : ViewModel> create(modelClass: Class<T>):T{
        if (modelClass.isAssignableFrom(SecondFragmentViewModel::class.java)){
            return SecondFragmentViewModel(ordenA) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel class")
    }

}