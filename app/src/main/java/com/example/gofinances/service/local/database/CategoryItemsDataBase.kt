package com.example.gofinances.service.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gofinances.service.local.dao.CategoryItemsDAO
import com.example.gofinances.service.local.entity.CategoryItemsEntity

@Database(entities = [CategoryItemsEntity::class], version = 1)
abstract class CategoryItemsDataBase : RoomDatabase() {
    abstract fun categoryItemsDAO(): CategoryItemsDAO

    companion object {
        private lateinit var INSTANCE: CategoryItemsDataBase
        fun getDataBase(context: Context): CategoryItemsDataBase {
            if (!::INSTANCE.isInitialized) {
                synchronized(LoginDataBase::class.java) {
                    INSTANCE =
                        Room.databaseBuilder(context, CategoryItemsDataBase::class.java, "category_database")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return INSTANCE
        }
    }
}