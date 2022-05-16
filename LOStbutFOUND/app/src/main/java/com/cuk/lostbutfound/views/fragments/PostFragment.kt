package com.cuk.lostbutfound.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cuk.lostbutfound.R
import com.cuk.lostbutfound.data.ItemVM
import com.cuk.lostbutfound.data.LostItem
import com.cuk.lostbutfound.databinding.FragmentPostBinding


class PostFragment : Fragment() {
    private lateinit var postBinding: FragmentPostBinding
    private lateinit var mitemVM: ItemVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        postBinding = FragmentPostBinding.inflate(inflater, container, false)

        mitemVM = ViewModelProvider(this).get(ItemVM::class.java)

        postBinding.postBn.setOnClickListener{
            insertItem()
        }

        return postBinding.root
    }

    private fun insertItem() {
        //get value in fields
        val ttl = postBinding.titleEt.text.toString().trim()
        val pst = postBinding.postEt.text.toString().trim()
        val cnt = postBinding.contactEt.text.toString().trim()

        if(fieldsFilled()) {
            val item = LostItem(0, ttl, pst, cnt)

            //add item to database
            mitemVM.addItem(item)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

            //go back to post page
            findNavController().navigate(R.id.action_postFragment_to_lostItemFragment)
        }else{
            //message to user to fill all fields
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_LONG).show()
        }
    }

    //check if all fields are populated
    private fun fieldsFilled(): Boolean {
        return !(postBinding.titleEt.text.isNullOrEmpty() || postBinding.postEt.text.isNullOrEmpty() || postBinding.contactEt.text.isNullOrEmpty())
    }

}