package com.example.gofinances.service.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login_table")
class LoginEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int = 0

    @ColumnInfo(name = "name")
    var name:String = ""

    @ColumnInfo(name = "email")
    var email:String = ""

    @ColumnInfo(name = "password")
    var password:String = ""
}