package com.example.gofinances.service.local.model

import com.example.gofinances.service.local.entity.ExpenseEntity

interface ExpenseRepositoryModel {
    fun getAllExpenseItems(): List<ExpenseEntity>

    fun createExpenseItem(expenseItem: ExpenseEntity)
}