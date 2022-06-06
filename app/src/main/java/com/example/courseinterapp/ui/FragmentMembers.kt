package com.example.courseinterapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.courseinterapp.R
import com.example.courseinterapp.data.Icon
import com.example.courseinterapp.data.Memory
import com.example.courseinterapp.databinding.FragmentMembersBinding
import com.example.courseinterapp.ui.adapters.CardAdapter
import com.example.courseinterapp.ui.adapters.IconAdapter
import com.example.courseinterapp.ui.adapters.decorators.FeedHorizontalDividerItemDecoration
import com.example.courseinterapp.ui.adapters.decorators.FeedVerticalDividerItemDecoration

class FragmentMembers : Fragment(R.layout.fragment_members) {

    private val binding: FragmentMembersBinding by viewBinding()

    private val cardAdapter: CardAdapter by lazy { CardAdapter() }
    private val iconAdapter: IconAdapter by lazy { IconAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            cardList.adapter = cardAdapter
            cardList.layoutManager = LinearLayoutManager(requireContext())
            iconList.adapter = iconAdapter
        }
        cardAdapter.setList(list)
        iconAdapter.setList(iconList)
        binding.cardList.addItemDecoration(FeedVerticalDividerItemDecoration(16, cardAdapter.itemCount))
        binding.iconList.addItemDecoration(FeedHorizontalDividerItemDecoration(16, iconAdapter.itemCount))
    }
    companion object {
        fun newInstance() = FragmentMembers()

        private val iconList = listOf(
            Icon.Active(0, "zero"),
            Icon.Disable(1, "first"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
        )

        private val list = listOf(
            Memory(0, "zero", "zero desc", ""),
            Memory(1, "first", "first desc", ""),
            Memory(2, "second", "second desc", ""),
            Memory(3, "third", "third desc", ""),
            Memory(4, "forth", "forth desc", ""),
            Memory(5, "fifth", "fifth desc", ""),
            Memory(6, "sixth", "sixth desc", ""),
            Memory(7, "seventh", "seventh desc", ""),
        )
    }
}