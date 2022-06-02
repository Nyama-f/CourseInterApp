package com.example.courseinterapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.courseinterapp.data.Memory
import com.example.courseinterapp.databinding.CardViewHolderBinding


class CardAdapter : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    private val items: MutableList<Memory> = mutableListOf()

    fun setList(list: List<Memory>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardViewHolderBinding.inflate(inflater, parent, false)

        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CardViewHolder,
        position: Int
    ) {
        val item = items[position]
        holder.onBind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class CardViewHolder(private val binding: CardViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Memory) {
            with(binding) {
                title.text = item.title
                subTitle.text = item.description
            }
        }
    }
}