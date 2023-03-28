package com.example.pharaonmystery.lose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pharaonmystery.databinding.FragmentLoseBinding
import com.example.pharaonmystery.router

class LoseFragment : Fragment() {
    private var _binding: FragmentLoseBinding? = null
    private val binding: FragmentLoseBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoseBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.again.setOnClickListener {
            router?.navigateToGame()
        }
    }
}