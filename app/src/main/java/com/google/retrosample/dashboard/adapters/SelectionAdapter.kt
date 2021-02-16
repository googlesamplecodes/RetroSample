package com.google.retrosample.dashboard.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.retrosample.R
import com.google.retrosample.dashboard.interfaces.AddMinusListener
import com.google.retrosample.dashboard.models.Fruit


class SelectionAdapter(var context: Context, var addMinusListener: AddMinusListener) :
    RecyclerView.Adapter<SelectionAdapter.SelectionHolder>() {

    var userlist: List<Fruit> = mutableListOf()
    var selecteduserlist: List<Fruit> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectionHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.row_seletion_item_layout, parent, false)
        return SelectionHolder(view)
    }

    override fun onBindViewHolder(holder: SelectionHolder, position: Int) {

        with(userlist) {
            holder.txt_item.text = this.get(position).name + " " + this.get(position).count
            holder.btn_plus.setOnClickListener({
                val fruit = Fruit(this.get(position).name, get(position).count + 1)
                addMinusListener.addItem(fruit)
            })
            holder.btn_minus.setOnClickListener({
                val fruit = Fruit(this.get(position).name, get(position).count - 1)
                addMinusListener.minusItem(fruit)
            })
        }
    }

    override fun getItemCount(): Int {
        return userlist?.size
    }

    fun setData(list: List<Fruit>) {
        userlist = list
        notifyDataSetChanged()
    }
    fun setSelectedData(list: List<Fruit>){
        userlist = list
        Log.e("UserList",userlist.toString())
        notifyDataSetChanged()
    }

    class SelectionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txt_item: TextView
        var btn_minus: Button
        var btn_plus: Button

        init {
            txt_item = itemView.findViewById(R.id.txt_item)
            btn_minus = itemView.findViewById(R.id.btn_minus)
            btn_plus = itemView.findViewById(R.id.btn_plus)
        }
    }
}