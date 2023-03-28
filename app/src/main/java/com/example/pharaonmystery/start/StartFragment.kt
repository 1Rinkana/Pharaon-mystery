package com.example.pharaonmystery.start

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pharaonmystery.databinding.FragmentStartBinding
import com.example.pharaonmystery.router

class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding? = null
    private val binding: FragmentStartBinding get() = _binding!!
    private val rulesText = "No info"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.info.setOnClickListener {
            showRules()
        }
        //как включать и выключать звук
        binding.start.setOnClickListener {
            router?.navigateToGame()
        }
    }

    private fun showRules() {
        AlertDialog.Builder(requireContext())
            .setTitle("Rules")
            .setMessage(rulesText)
            .setPositiveButton("Back to game") { dialog, _ -> dialog.dismiss() }
            .show()
    }

}