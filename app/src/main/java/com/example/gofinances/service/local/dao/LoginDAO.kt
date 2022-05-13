package com.example.gofinances.service.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gofinances.service.local.entity.LoginEntity

@Dao
interface LoginDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createUser(user:LoginEntity)

    @Query("SELECT * FROM login_table WHERE email=:email AND password=:password")
    fun getUser(email:String, password:String): LoginEntity
}