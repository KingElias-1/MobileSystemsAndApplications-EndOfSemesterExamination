package com.cuk.lostbutfound.data

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LostItem::class], version = 1, exportSchema = false)
abstract class LostItemDatabase: RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object{
        @Volatile
        private var INSTANCE: LostItemDatabase? = null

        fun getDatabase(context: Context): LostItemDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LostItemDatabase::class.java,
                    "lost_item_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}