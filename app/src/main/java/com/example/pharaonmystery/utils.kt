package com.example.pharaonmystery

import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment

val Fragment.router: Router? get() = activity as? Router

fun doWithDelay(callback: () -> Unit, delay: Long) {
    Handler(Looper.getMainLooper()).postDelayed(callback, delay)
}