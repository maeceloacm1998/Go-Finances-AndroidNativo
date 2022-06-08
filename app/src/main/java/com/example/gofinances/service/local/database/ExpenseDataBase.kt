package com.example.gofinances.service.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gofinances.service.local.dao.CategoryItemsDAO
import com.example.gofinances.service.local.dao.ExpenseDAO
import com.example.gofinances.service.local.entity.CategoryItemsEntity
import com.example.gofinances.service.local.entity.ExpenseEntity

@Database(entities = [ExpenseEntity::class], version = 1)
abstract class ExpenseDataBase: RoomDatabase() {
    abstract fun expenseDAO(): ExpenseDAO

    companion object {
        private lateinit var INSTANCE: ExpenseDataBase
        fun getDataBase(context: Context): ExpenseDataBase {
            if (!::INSTANCE.isInitialized) {
                synchronized(ExpenseDataBase::class.java) {
                    INSTANCE =
                        Room.databaseBuilder(context, ExpenseDataBase::class.java, "expense_database")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return INSTANCE
        }
    }
}