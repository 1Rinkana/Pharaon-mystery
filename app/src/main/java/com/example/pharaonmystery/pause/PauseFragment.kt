package com.example.pharaonmystery.pause

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pharaonmystery.databinding.FragmentPauseBinding
import com.example.pharaonmystery.router

class PauseFragment: Fragment() {
    private var _binding: FragmentPauseBinding? = null
    private val binding: FragmentPauseBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPauseBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.pauseNext.setOnClickListener {
            router?.navigateToGame()
        }

        binding.pauseResume.setOnClickListener {
            router?.navigateToGame()
        }
    }
}