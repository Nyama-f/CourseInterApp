package com.example.courseinterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.courseinterapp.databinding.ActivityMainBinding
import com.example.courseinterapp.ui.adapters.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = checkNotNull(_binding) { "Binding is null" }
    //private lateinit var adapter: ContactsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initial()


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

    private fun initial(){
        // Добавление адаптера во ViewPager
        binding.viewPager.adapter = PagerAdapter(this)
        // TabLayoutMediator класс для взаимодействия с Tablayout
        TabLayoutMediator(binding.tabLayout, binding.viewPager){
                tab, pos ->
            when(pos){
                0 -> {
                    tab.setIcon(R.drawable.android)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.green))
                }
                1 -> {
                    tab.setIcon(R.drawable.account)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.orange))
                    tab.icon?.alpha = 100
                }
                2 -> {
                    tab.setIcon(R.drawable.desktop)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.blue))
                    tab.icon?.alpha = 100
                }
            }
        }.attach()
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.icon?.alpha = 250
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.alpha = 100
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                TODO("Not yet implemented")
            }

        })
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