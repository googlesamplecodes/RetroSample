package com.google.retrosample.dashboard.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.retrosample.R
import com.google.retrosample.dashboard.models.Fruit


class ShowAdapter(var context: Context) : RecyclerView.Adapter<ShowAdapter.ShowHolder>() {

    var confirmList: List<Fruit> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_item_show, parent, false)
        return ShowHolder(view)
    }

    override fun onBindViewHolder(holder: ShowHolder, position: Int) {

        with(confirmList) {
            holder.txt_fruit.text = get(position).name
            holder.txt_count.text = get(position).count.toString()
        }
    }

    override fun getItemCount(): Int {
        return confirmList?.size
    }

    fun setData(list: List<Fruit>) {
        confirmList = list
        notifyDataSetChanged()
    }

    class ShowHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_fruit: TextView
        var txt_count: TextView

        init {
            txt_fruit = itemView.findViewById(R.id.txt_fruit)
            txt_count = itemView.findViewById(R.id.txt_count)
        }
    }
}