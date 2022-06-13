package com.example.courseinterapp.ui

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import com.example.courseinterapp.data.model.Contact
import com.example.courseinterapp.ui.adapters.ContactsListAdapter
import com.example.courseinterapp.databinding.FragmentListContactBinding
import com.example.courseinterapp.ui.services.MyService


class ListContactFragment : Fragment() {

    private var _binidng: FragmentListContactBinding? = null
    private val binding get() = checkNotNull(_binidng){ "Binding is null" }

    private val adapter by lazy {
        ContactsListAdapter()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binidng = FragmentListContactBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onStart() {
        super.onStart()
        val permissionGranted = context?.let {
            ActivityCompat.checkSelfPermission(
                it,
                android.Manifest.permission.READ_CONTACTS
            )
        } == PackageManager.PERMISSION_GRANTED
        if(permissionGranted){
            requireActivity().startService(MyService.newIntent(activity))
            //startService(MyService.newIntent(getActivity()))
            setupRecyclerView()
        }else{
            requestPermission()
        }
    }
    private fun setupRecyclerView(){
        val rvContactList = binding.rvContactsList
        //adapter = ContactsListAdapter()
        // Добавление нашего листа в адаптер, чтобы ему было с чем работать
        adapter.contactsList = contactsList
        rvContactList.adapter = adapter

    }

    // Запрашиваем разрешение у пользователя
    private fun requestPermission(){
        getActivity()?.let {
            ActivityCompat.requestPermissions(
                it,
                arrayOf(android.Manifest.permission.READ_CONTACTS),
                READ_CONTACTS_REQUEST_CODE
            )
        }
    }
    // Метод будет вызван, когда пользователь даст ответ
    // Переопределяю метод, чтобы понять, дал пользователь ответ или нет
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        // Если пользователь дал какое то решение на данный запрос
        if(requestCode == READ_CONTACTS_REQUEST_CODE && grantResults.isNotEmpty()){
            val permissionGranted = grantResults[0] == PackageManager.PERMISSION_GRANTED
            if(permissionGranted){
                requireActivity().startService(MyService.newIntent(activity))
                //startService(MyService.newIntent(getActivity()))
            }else{
                // Второй раз спрашивать у пользователя не будем
                Log.d("MainActivity", "Permission denied")
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    companion object{
        private const val READ_CONTACTS_REQUEST_CODE = 100
        var contactsList = mutableListOf<Contact>()
    }
}