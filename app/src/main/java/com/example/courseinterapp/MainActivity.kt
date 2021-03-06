package com.example.courseinterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.courseinterapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = checkNotNull(_binding) { "Binding is null" }
    //private lateinit var adapter: ContactsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val navControllerFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
//        navControllerFragment.findNavController()
//            supportFragmentManager.findFragmentById(R.id.navContainer) as NavHostFragment
//        navControllerFragment.findNavController()
//        val permissionGranted = ActivityCompat.checkSelfPermission(
//            this,
//            android.Manifest.permission.READ_CONTACTS
//        ) == PackageManager.PERMISSION_GRANTED
//        if(permissionGranted){
//            startService(MyService.newIntent(this))
//            setupRecyclerView()
//        }else{
//            requestPermission()
//        }
    }

//    private fun setupRecyclerView(){
//        val rvContactList = findViewById<RecyclerView>(R.id.rv_contacts_list)
//        adapter = ContactsListAdapter()
//        // Добавление нашего листа в адаптер, чтобы ему было с чем работать
//        adapter.contactsList = contactsList
//        rvContactList.adapter = adapter
//
//    }
//
//    // Запрашиваем разрешение у пользователя
//    private fun requestPermission(){
//        ActivityCompat.requestPermissions(
//            this,
//            arrayOf(android.Manifest.permission.READ_CONTACTS),
//            READ_CONTACTS_REQUEST_CODE
//        )
//    }
    // Метод будет вызван, когда пользователь даст ответ
    // Переопределяю метод, чтобы понять, дал пользователь ответ или нет
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        // Если пользователь дал какое то решение на данный запрос
//        if(requestCode == READ_CONTACTS_REQUEST_CODE && grantResults.isNotEmpty()){
//            val permissionGranted = grantResults[0] == PackageManager.PERMISSION_GRANTED
//            if(permissionGranted){
//                startService(MyService.newIntent(this))
//            }else{
//                // Второй раз спрашивать у пользователя не будем
//                Log.d("MainActivity", "Permission denied")
//            }
//        }
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//    }

//    companion object{
//        private const val READ_CONTACTS_REQUEST_CODE = 100
//        var contactsList = mutableListOf<Contact>()
//    }
}