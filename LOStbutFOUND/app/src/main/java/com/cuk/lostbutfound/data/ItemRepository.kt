package com.cuk.lostbutfound.data

import androidx.lifecycle.LiveData

class ItemRepository(private val itemDao: ItemDao) {
    val getAllItemsR: LiveData<List<LostItem>> = itemDao.getAllItems()

    suspend fun addItemR(lostItem: LostItem){
        itemDao.addItem(lostItem)
    }
}