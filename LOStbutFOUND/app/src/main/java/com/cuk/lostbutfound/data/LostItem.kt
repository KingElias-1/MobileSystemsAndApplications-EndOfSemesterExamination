package com.cuk.lostbutfound.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lost_item")
data class LostItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val post: String,
    val contact: String
)
