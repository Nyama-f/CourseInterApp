package com.example.courseinterapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.courseinterapp.data.model.User
import com.example.courseinterapp.databinding.UserViewHolderBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val userList: MutableList<User> = mutableListOf()


    fun setList(list: List<User>) {
        userList.clear()
        userList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserViewHolderBinding.inflate(inflater, parent, false)

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: UserViewHolder,
        position: Int
    ) {
        val item = userList[position]
        holder.onBind(item)
    }

    override fun getItemCount(): Int = userList.size

    inner class UserViewHolder(private val binding: UserViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: User) {
            with(binding) {
                userName.text = item.userName
                userEmail.text = item.userEmail
                Glide.with(binding.root).load(item.userImage).centerCrop().into(userImage)
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