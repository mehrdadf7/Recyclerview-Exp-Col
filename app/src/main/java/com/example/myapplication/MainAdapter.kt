package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter(
    private val subItemClickListener: (SubModel) -> Unit
): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val items: MutableList<MainModel> = mutableListOf()

    fun addItems(items: MutableList<MainModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class MainViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        fun bind(mainModel: MainModel) {

            itemView.tv_main_title.text = mainModel.title

            if (mainModel.isExpanded) {
                itemView.rv_sub_items.visibility = View.VISIBLE
            } else {
                itemView.rv_sub_items.visibility = View.GONE
            }

            val subItemAdapter = SubItemAdapter(mainModel.subModels) { subModel ->
                subItemClickListener(subModel)
            }
            itemView.rv_sub_items.apply {
                isNestedScrollingEnabled = false
                setHasFixedSize(true)
                adapter = subItemAdapter
            }

            itemView.setOnClickListener {
                mainModel.isExpanded = !mainModel.isExpanded
                notifyItemChanged(adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_main, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}