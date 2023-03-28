package com.example.pharaonmystery

interface Router {
    fun navigateToGame()
    fun navigateToStart()
    fun navigateToWin()
    fun navigateToLose()
    fun navigateToOffline()
    fun navigateToPause()
    fun navigateToLoading()
}