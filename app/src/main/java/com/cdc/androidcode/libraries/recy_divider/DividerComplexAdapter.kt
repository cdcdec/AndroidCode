package com.cdc.androidcode.libraries.recy_divider

import android.content.Context
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cdc.androidcode.R
import com.cdc.androidcode.libraries.recy_divider.itemdecoration.FlexibleDividerDecoration
import com.cdc.androidcode.libraries.recy_divider.itemdecoration.HorizontalDividerItemDecoration


class DividerComplexAdapter(context: Context):RecyclerView.Adapter<DividerComplexAdapter.ViewHolder>(),
    FlexibleDividerDecoration.PaintProvider,FlexibleDividerDecoration.VisibilityProvider,
    HorizontalDividerItemDecoration.MarginProvider{
    override fun dividerPaint(position: Int, p1: RecyclerView?): Paint {
        val paint = Paint()
        when (position % 10) {
            0 -> {
                paint.color = Color.RED
                paint.strokeWidth = 30f
            }
            1 -> {
                paint.color = Color.MAGENTA
                paint.strokeWidth = 10f
            }
            else -> {
                if (position % 2 == 0) {
                    paint.color = Color.BLUE
                    paint.isAntiAlias = true
                    paint.pathEffect = DashPathEffect(floatArrayOf(25.0f, 25.0f), 0f)
                } else {
                    paint.color = Color.GREEN

                }
                paint.strokeWidth = (2 + position).toFloat()
            }
        }

        return paint
    }

    override fun shouldHideDivider(position: Int, p1: RecyclerView?): Boolean {
        return position == 14 || position == 15
    }

    override fun dividerLeftMargin(position: Int, p1: RecyclerView?): Int {
        return if (position < 10) {
            position * 20
        } else {
            (20 - position) * 20
        }
    }

    override fun dividerRightMargin(position: Int, p1: RecyclerView?): Int {
        return if (position < 10) {
            position * 20 + 20
        } else {
            (20 - position) * 20 + 20
        }
    }

    var layoutInflater: LayoutInflater? =null

    init {
        layoutInflater= LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view= layoutInflater?.inflate(R.layout.layout_divider_item,parent,false)
        return ViewHolder(view!!)
    }

    override fun getItemCount(): Int {
        return 20
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