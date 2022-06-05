package com.example.gofinances.service.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_items_table")
class CategoryItemsEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name= "name")
    var name:String = ""

    @ColumnInfo(name= "icon")
    var icon:Int = 0
}