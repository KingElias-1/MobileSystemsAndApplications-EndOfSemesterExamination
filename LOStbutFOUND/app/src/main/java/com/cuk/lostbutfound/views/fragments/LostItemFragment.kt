package com.cuk.lostbutfound.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuk.lostbutfound.R
import com.cuk.lostbutfound.data.ItemVM
import com.cuk.lostbutfound.data.LostItem
import com.cuk.lostbutfound.databinding.FragmentLostItemBinding
import com.cuk.lostbutfound.views.adapter.ItemListAdapter


class LostItemFragment : Fragment() {
    private lateinit var mItemVM: ItemVM
    private lateinit var lostBinding: FragmentLostItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        lostBinding = FragmentLostItemBinding.inflate(inflater, container, false)

        val adapter = ItemListAdapter()
        val recyclerView = lostBinding.recV
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mItemVM = ViewModelProvider(this).get(ItemVM::class.java)
        mItemVM.getAllItemsVM.observe(viewLifecycleOwner, Observer { item ->
            adapter.setData(item )
        })

        return lostBinding.root
    }

}