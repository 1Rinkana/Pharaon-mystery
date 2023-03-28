package com.example.pharaonmystery.game

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pharaonmystery.R
import com.example.pharaonmystery.databinding.FragmentGameBinding
import com.example.pharaonmystery.router
import kotlin.concurrent.thread
import kotlin.random.Random.Default.nextInt

interface GameListener {
    fun onWin()
}

class GameFragment : Fragment(), GameListener {

    private var time = 60
    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding get() = _binding!!
    private var adapter: CellAdapter = CellAdapter(this)
    private val rv: RecyclerView by lazy { binding.rvCell }
    private val colorList = mutableListOf<Int>(R.drawable.blue, R.drawable.red, R.drawable.burgundy,
        R.drawable.green, R.drawable.orange, R.drawable.yellow)
    private val numList = mutableListOf<Int>(R.drawable.one, R.drawable.two, R.drawable.three,
        R.drawable.four, R.drawable.five, R.drawable.six,
        R.drawable.seven, R.drawable.eight, R.drawable.nine)
    private var isPaused: Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rv.adapter = adapter
        adapter.setList(myCell())
        binding.pause.setOnClickListener {
            isPaused = true
            router?.navigateToStart()
        }
        thread {
            while(time > 0) {
                Thread.sleep(1000)
                if (!isPaused) {
                    time -= 1
                    activity?.runOnUiThread {
                        if(time <= 0) {
                            router?.navigateToLose()
                            isPaused = true
                        }
                        binding.timer.text = "Time: $time"
                    }
                }
            }
        }
    }

    private fun myCell(): ArrayList<CellModel> {
        val emptyCells = ArrayList<CellModel>()
        val cellList = ArrayList<CellModel>()
        repeat(21) { emptyCells.add(CellModel(R.drawable.cell, R.drawable.cell, true)) }
        repeat(21) {
            val newCell = CellModel(colorList[nextInt(0, 5)], numList[nextInt(0, 8)])
            repeat(2) { cellList.add(newCell) }
        }
        cellList.shuffle()
        return (emptyCells + cellList) as ArrayList<CellModel>
    }

    override fun onWin() {
        router?.navigateToWin()
        isPaused = true
    }
}