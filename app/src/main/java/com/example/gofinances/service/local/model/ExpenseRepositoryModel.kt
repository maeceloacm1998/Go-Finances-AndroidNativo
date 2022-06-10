package com.example.gofinances.service.local.model

import androidx.room.Query
import com.example.gofinances.service.local.entity.ExpenseEntity

interface ExpenseRepositoryModel {
    fun getAllExpenseItems(): List<ExpenseEntity>

    fun createExpenseItem(expenseItem: ExpenseEntity)

    fun getSpecificType(type:String): List<ExpenseEntity>

    fun getPricePerType(type: String): Float

    fun getFirstRegister(): Long

    fun getLastRegister(): Long
}