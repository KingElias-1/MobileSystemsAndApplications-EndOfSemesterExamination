package com.cuk.lostbutfound.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.selects.select

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(lostItem: LostItem)

    @Query("select * from lost_item order by id asc")
    fun getAllItems(): LiveData<List<LostItem>>
}