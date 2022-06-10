package com.example.courseinterapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.courseinterapp.data.model.Memory
import com.example.courseinterapp.databinding.CardViewHolderBinding


class CardAdapter : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    private val items: MutableList<Memory> = mutableListOf()
    //    var cardImageClickListener: CardImageClickListener? = null
//    var cardTitleClickListener: CardTitleClickListener? = null
    var cardImageClickListener: (() -> Unit)? = null
    var cardTitleCickListener: (() -> Unit)? = null

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
//                mainImage.setOnClickListener{ cardImageClickListener?.onCLick() }
//                title.setOnClickListener { cardTitleClickListener?.onCLick() }
                mainImage.setOnClickListener { cardImageClickListener?.invoke() }
                title.setOnClickListener { cardTitleCickListener?.invoke() }
            }
        }
    }
// Зачем нам создавать функциональный интерфейс,
// когда мы можем в поле типа interface, сохранить лямбду
// в таком случае вызов станет попроще
//    fun interface CardImageClickListener{
//        fun onCLick()
//    }
//    fun interface CardTitleClickListener{
//        fun onCLick()
//    }
}
