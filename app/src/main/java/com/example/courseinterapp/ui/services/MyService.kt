package com.example.courseinterapp.ui.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.example.courseinterapp.data.model.Contact
import com.example.courseinterapp.ui.ListContactFragment
import kotlin.concurrent.thread

class MyService: Service() {
    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
    }

    // Здесь происходит вся работа сервиса *по умлочанию выполняется в главном потоке*
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        requestContacts()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun requestContacts(){
        thread {
            val cursor = contentResolver.query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                null
            )
            while (cursor?.moveToNext() == true){
                val id = cursor.getInt(
                    cursor.getColumnIndexOrThrow(ContactsContract.Contacts._ID)
                )
                val name = cursor.getString(
                    cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME)
                )
                val contact = Contact(id, name)
                ListContactFragment.contactsList.add(contact)
                Log.d("ListContactFragment", contact.toString())
            }
            cursor?.close()
        }
    }

    companion object{
        fun newIntent(context: FragmentActivity?): Intent{
            return Intent(context, MyService::class.java)
        }
    }
}