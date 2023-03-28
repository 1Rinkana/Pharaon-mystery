package com.example.pharaonmystery.game

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pharaonmystery.R
import com.example.pharaonmystery.databinding.ItemCellLayoutBinding

class CellAdapter(val listener: GameListener): RecyclerView.Adapter<CellAdapter.CellViewHolder>() {

    private var cellList = emptyList<CellModel>()
    var pressedBtn: CellModel? = null


    class CellViewHolder(val view: ItemCellLayoutBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        val view = ItemCellLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return CellViewHolder(view)
    }

    override fun getItemCount(): Int = cellList.size

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        holder.view.cellColour.setImageResource(cellList[position].color)
        holder.view.cellNum.setImageResource(cellList[position].num_image)
        holder.itemView.setOnClickListener {
            if (pressedBtn == null) {
                pressedBtn = cellList[position]
                holder.view.cellColour.setImageResource(R.drawable.cell)
                cellList[position].isDestroyed = true
            } else {
                if (cellList[position].num_image == pressedBtn!!.num_image &&
                        cellList[position].color == pressedBtn!!.color) {
                    holder.view.cellColour.setImageResource(R.drawable.cell)
                    pressedBtn = null
                    cellList[position].isDestroyed = true
                    if(checkForWin()) listener.onWin()
                } else {
                    Toast.makeText(holder.view.root.context, "Wrong!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun checkForWin(): Boolean = cellList.all { it.isDestroyed }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CellModel>) {
        cellList = list
        notifyDataSetChanged()
    }
}