package com.example.pharaonmystery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pharaonmystery.offline.OfflineFragment
import com.example.pharaonmystery.game.GameFragment
import com.example.pharaonmystery.loading.LoadingFragment
import com.example.pharaonmystery.lose.LoseFragment
import com.example.pharaonmystery.pause.PauseFragment
import com.example.pharaonmystery.start.StartFragment
import com.example.pharaonmystery.win.WinFragment

class MainActivity : AppCompatActivity(), Router {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateToLoading()
    }

    override fun navigateToGame() {
        navigateTo(GameFragment())
    }

    override fun navigateToStart() {
        navigateTo(StartFragment())
    }

    override fun navigateToWin() {
        navigateTo(WinFragment())
    }

    override fun navigateToLose() {
        navigateTo(LoseFragment())
    }


    override fun navigateToOffline() {
        navigateTo(OfflineFragment())
    }

    override fun navigateToPause() {
        navigateTo(PauseFragment())
    }

    override fun navigateToLoading() {
        navigateTo(LoadingFragment())
    }

    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}