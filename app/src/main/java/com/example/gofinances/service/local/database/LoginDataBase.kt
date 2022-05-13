package com.example.gofinances.service.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gofinances.service.local.dao.LoginDAO
import com.example.gofinances.service.local.entity.LoginEntity

@Database(entities = [LoginEntity::class], version = 1)
abstract class LoginDataBase() : RoomDatabase() {

    abstract fun loginDAO(): LoginDAO

    companion object {
        private lateinit var INSTANCE: LoginDataBase
        fun getDataBase(context: Context): LoginDataBase {
            if (!::INSTANCE.isInitialized) {
                synchronized(LoginDataBase::class.java) {
                    INSTANCE =
                        Room.databaseBuilder(context, LoginDataBase::class.java, "login_database")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return INSTANCE
        }
    }
}