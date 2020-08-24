package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_sub.view.*

class SubItemAdapter(
    private val subItems: MutableList<SubModel>,
    private val subItemClickListener: (SubModel) -> Unit
): RecyclerView.Adapter<SubItemAdapter.SubItemViewHolder>() {

    inner class SubItemViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(subModel: SubModel) {
            itemView.tv_sub_title.text = subModel.subTitle

            itemView.setOnClickListener {
                subItemClickListener(subModel)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubItemViewHolder {
        return SubItemViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_sub, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SubItemViewHolder, position: Int) {
        holder.bind(subItems[position])
    }

    override fun getItemCount(): Int {
        return subItems.size
    }


}