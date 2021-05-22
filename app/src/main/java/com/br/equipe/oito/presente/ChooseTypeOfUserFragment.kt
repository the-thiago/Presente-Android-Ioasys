package com.br.equipe.oito.presente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.br.equipe.oito.presente.databinding.FragmentChooseTypeOfUserBinding

class ChooseTypeOfUserFragment : Fragment() {

    private var _binding: FragmentChooseTypeOfUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseTypeOfUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.btnContinue.setOnClickListener {
            findNavController().navigate(ChooseTypeOfUserFragmentDirections.actionChooseTypeOfUserFragmentToChooseTypeOfSessionFragment())
        }
        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}