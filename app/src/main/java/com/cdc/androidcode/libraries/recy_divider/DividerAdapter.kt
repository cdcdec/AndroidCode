package com.cdc.androidcode.libraries.recy_divider

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cdc.androidcode.R


class DividerAdapter(context: Context):RecyclerView.Adapter<DividerAdapter.ViewHolder>(){
        var layoutInflater: LayoutInflater? =null

    init {
        layoutInflater= LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view= layoutInflater?.inflate(R.layout.layout_divider_item,parent,false)
        return ViewHolder(view!!)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text="Kotlin默认内部类是静态内部类${position+1}"
        holder.tvAuthor.text="新闻作者${position+1}"
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle= itemView.findViewById<TextView>(R.id.tvTitle)!!
        var tvAuthor= itemView.findViewById<TextView>(R.id.tvAuthor)!!



    }
}