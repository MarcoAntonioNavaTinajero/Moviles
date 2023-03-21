package com.example.practica1android

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.practica1android.database.Comanda
import com.example.practica1android.database.PizzasDataBase
import com.example.practica1android.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private lateinit var viewModel: SecondFragmentViewModel
    private lateinit var viewModelFactory: SecondFragmentViewModelFactory

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
//        val binding: FragmentSecondBinding = DataBindingUtil.inflate(
//            inflater, R.layout.fragment_second, container, false)


        val application = requireNotNull(this.activity).application

        val dataSource = PizzasDataBase.getInstance(application).ordenDatabaseDao

        viewModelFactory = SecondFragmentViewModelFactory(SecondFragmentArgs.fromBundle(requireArguments()).orden, dataSource, application)
        viewModel = ViewModelProvider(this,viewModelFactory).get(SecondFragmentViewModel::class.java)
        muestraOrdenes()

        _binding!!.secondFragmentViewModel = viewModel

        _binding!!.setLifecycleOwner(this)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.orden_mutable.observe(this, Observer {
            orden ->
        orden?.let {
            this.findNavController().navigate(
                SecondFragmentDirections.actionSecondFragmentToFragmentThird(orden.ordenId))
            viewModel.doneNavigating()
        }
        })

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            Log.i("SecondViewModel","Se pulso el boton")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun displayToast(mesage: String) {
        Toast.makeText(binding.root.context, mesage, Toast.LENGTH_SHORT).show()
    }

    fun muestraOrdenes(){
        var ordenes = "Tu orden: "
        val textView = binding.textviewSecond
        textView.text = viewModel.getOrden()!!.joinToString("\n")
        for(item in viewModel.getOrden()!!){
            ordenes += "\n"+item
        }
        displayToast(ordenes)
        }
    }
//}