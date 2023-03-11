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
import com.example.practica1android.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {



    private lateinit var viewModel: OrdenViewModel

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        Log.i("FirstFragment", "Se ha llamado el ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(OrdenViewModel::class.java)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            nextButton()
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.pizzadulce.setOnClickListener{
            viewModel.addOrden("Agregaste pizza dulce")
            muestraOrdenes()
            viewModel.incrementar()
            binding.contador.text = viewModel.getContador().toString()
        }

        binding.pizzafresa.setOnClickListener{
            viewModel.addOrden("Agregaste pizza fresa")
            muestraOrdenes()
            viewModel.incrementar()
            binding.contador.text = viewModel.getContador().toString()
        }

        binding.pizzagitomate.setOnClickListener{
            viewModel.addOrden("Agregaste pizza gitomate")
            muestraOrdenes()
            viewModel.incrementar()
            binding.contador.text = viewModel.getContador().toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun nextButton(){
        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(viewModel.getOrden()!!.toTypedArray())
        findNavController().navigate(action)
        //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }


    fun displayToast(message : String){
        Toast.makeText(binding.root.context, message, Toast.LENGTH_SHORT).show()
    }

    fun muestraOrdenes(){
        for(item in viewModel.getOrden()!!){
            displayToast(item)
        }
    }

}