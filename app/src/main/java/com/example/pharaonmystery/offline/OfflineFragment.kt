package com.example.pharaonmystery.offline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pharaonmystery.databinding.FragmentOfflineBinding
import com.example.pharaonmystery.router

class OfflineFragment : Fragment() {
    private var _binding: FragmentOfflineBinding? = null
    private val binding: FragmentOfflineBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOfflineBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.playOffline.setOnClickListener {
            router?.navigateToGame()
        }
        binding.tryBtn.setOnClickListener {
            router?.navigateToLoading()
        }
    }
}