package com.example.practica1android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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
        viewModelFactory = SecondFragmentViewModelFactory(SecondFragmentArgs.fromBundle(requireArguments()).orden)
        viewModel = ViewModelProvider(this,viewModelFactory).get(SecondFragmentViewModel::class.java)
        muestraOrdenes()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun displayToast(message : String){
        Toast.makeText(binding.root.context, message, Toast.LENGTH_SHORT).show()
    }

    /*fun muestraOrdenes(){
        for(item in viewModel.getOrden()!!){
            displayToast(item)
        }
    }*/

    fun muestraOrdenes(){
        var orden = "Tu orden: "
        val textView = binding.textviewSecond
        textView.text = viewModel.getOrden()!!.joinToString("\n")
        for(item in viewModel.getOrden()!!){
            orden += "\n"+item
        }
    }
}