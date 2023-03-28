package com.example.pharaonmystery.loading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pharaonmystery.databinding.FragmentLoadingBinding
import com.example.pharaonmystery.doWithDelay
import com.example.pharaonmystery.router
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.InetAddress
import java.net.UnknownHostException

class LoadingFragment : Fragment() {
    private var _binding: FragmentLoadingBinding? = null
    private val binding: FragmentLoadingBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoadingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        doWithDelay({
            checkInternetConnection()
        }, 700)
    }

    private fun isInternetAvailable(): Boolean {
        try {
            val address: InetAddress = InetAddress.getByName("youtube.com")
            return !address.equals("")
        } catch (e: UnknownHostException) {
            // Log error
        }
        return false
    }

    fun checkInternetConnection() = CoroutineScope(Dispatchers.IO).launch {
        if(isInternetAvailable()) {
            withContext(Dispatchers.Main) {
                router?.navigateToStart()
            }
        } else {
            withContext(Dispatchers.Main) {
                router?.navigateToOffline()
            }
        }
    }
}