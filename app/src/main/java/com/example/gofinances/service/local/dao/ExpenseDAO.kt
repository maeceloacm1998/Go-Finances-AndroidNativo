package com.example.gofinances.service.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gofinances.service.local.entity.ExpenseEntity

@Dao
interface ExpenseDAO {
    @Query("SELECT * FROM expense_table")
    fun getAllExpenseItems(): List<ExpenseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createExpenseItem(expenseItem: ExpenseEntity)

    @Query("SELECT * FROM expense_table WHERE type =:type")
    fun getSpecificType(type: String): List<ExpenseEntity>
}