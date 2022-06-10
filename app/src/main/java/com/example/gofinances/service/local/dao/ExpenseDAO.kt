package com.example.gofinances.service.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gofinances.service.local.entity.ExpenseEntity
import com.example.gofinances.service.local.model.PricePerTypeModel

@Dao
interface ExpenseDAO {
    @Query("SELECT * FROM expense_table")
    fun getAllExpenseItems(): List<ExpenseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createExpenseItem(expenseItem: ExpenseEntity)

    @Query("SELECT * FROM expense_table WHERE type =:type")
    fun getSpecificType(type: String): List<ExpenseEntity>

    @Query("SELECT price FROM expense_table WHERE type == :type ")
    fun getPricePerType(type: String): List<String>

    @Query("SELECT dt_created FROM expense_table ORDER BY id DESC LIMIT 1")
    fun getFirstRegister(): Long

    @Query("SELECT dt_created FROM expense_table ORDER BY id ASC LIMIT 1")
    fun getLastRegister(): Long
}