package com.example.courseinterapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsListAdapter: RecyclerView.Adapter<ContactsListAdapter.ContactItemViewHolder>() {

    var contactsList = listOf<Contact>()
    @SuppressLint("NotifyDataSetChanged")
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    class ContactItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val contactName = view.findViewById<TextView>(R.id.contact_name)
        val contactId = view.findViewById<TextView>(R.id.contact_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_contact,
            parent,
            false
        )
        return ContactItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactItemViewHolder, position: Int) {
        val contactItem = contactsList[position]
        holder.contactName.text = contactItem.name
        holder.contactId.text = contactItem.id.toString()
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }
}