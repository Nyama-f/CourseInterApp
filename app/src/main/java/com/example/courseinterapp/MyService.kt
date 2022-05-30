package com.example.courseinterapp

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.provider.ContactsContract
import android.util.Log
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
                MainActivity.contactsList.add(contact)
                Log.d("MainActivity", contact.toString())
            }
            cursor?.close()
        }
    }

    companion object{
        fun newIntent(context: Context): Intent{
            return Intent(context, MyService::class.java)
        }
    }
}