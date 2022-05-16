package com.cuk.lostbutfound.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cuk.lostbutfound.data.LostItem
import com.cuk.lostbutfound.databinding.LostItemBinding


class ItemListAdapter: RecyclerView.Adapter<ItemListAdapter.ItemListViewHolder>() {

    private  var itemList = emptyList<LostItem>()

    class ItemListViewHolder(view: LostItemBinding): RecyclerView.ViewHolder(view.root) {
        val title = view.titleTv
        val post = view.postTv
        val cont = view.contactTv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        val binding: LostItemBinding =
            LostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.title.text = currentItem.title
        holder.post.text = currentItem.post
        holder.cont.text = currentItem.contact
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setData(item: List<LostItem>){
        this.itemList = item
        notifyDataSetChanged()
    }

}