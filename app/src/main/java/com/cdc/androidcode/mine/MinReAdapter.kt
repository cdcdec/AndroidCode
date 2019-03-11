package com.cdc.androidcode.mine
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.cdc.androidcode.R

class MinReAdapter(private val myDataset: Array<String>):RecyclerView.Adapter<MinReAdapter.MineItemViewHolder>(),View.OnClickListener {
    override fun onClick(v: View?) {
        mOnItemClickListener?.onItemClick(v!!, v.tag as Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MineItemViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.mine_item, parent, false) as CardView
        view.setOnClickListener(this)
        return MineItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(holder: MineItemViewHolder, position: Int) {
        holder.textView.text=myDataset[position]
        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.tag=position
    }


    class MineItemViewHolder(val view: View) : RecyclerView.ViewHolder(view){
         var textView:TextView=view.findViewById(R.id.mineItemTv)

    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    private var mOnItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.mOnItemClickListener = listener
    }
}