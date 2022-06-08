package com.example.gofinances.service.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense_table")
class ExpenseEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "dt_created")
    var dtCreated: Long = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "price")
    var price: String = ""

    @ColumnInfo(name = "type")
    var type: String = ""

    @ColumnInfo(name = "category")
    var category: String = ""

    @ColumnInfo(name = "icon_category")
    var iconCategory: Int = 0
}