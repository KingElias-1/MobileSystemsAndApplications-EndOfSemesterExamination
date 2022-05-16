package com.cuk.lostbutfound.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ItemVM (application: Application): AndroidViewModel(application){

    val getAllItemsVM: LiveData<List<LostItem>>
    private val repo: ItemRepository

    init {
        val itemDao = LostItemDatabase.getDatabase(application).itemDao()
        repo = ItemRepository(itemDao)
        getAllItemsVM = repo.getAllItemsR
    }

    fun addItem(item: LostItem){
        viewModelScope.launch((IO)) {
            repo.addItemR(item)
        }
    }
}