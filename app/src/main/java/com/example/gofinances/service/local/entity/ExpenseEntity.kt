package com.example.gofinances.service.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Expense")
class ExpenseEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "dt_created")
    val dtCreated: Int = 0

    @ColumnInfo(name = "name")
    val name: String = ""

    @ColumnInfo(name = "price")
    val price: String = ""

    @ColumnInfo(name = "type")
    val type: String = ""

    @ColumnInfo(name = "category")
    val category: String = ""
}