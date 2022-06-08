package com.example.gofinances.service.local.repository

import com.example.gofinances.service.local.database.ExpenseDataBase
import com.example.gofinances.service.local.entity.ExpenseEntity
import com.example.gofinances.service.local.model.ExpenseRepositoryModel

class ExpenseRepositoryRepository(private val database: ExpenseDataBase): ExpenseRepositoryModel {
    private val transaction get() = database.expenseDAO()

    override fun getAllExpenseItems(): List<ExpenseEntity> {
        return transaction.getAllExpenseItems()
    }

    override fun createExpenseItem(expenseItem: ExpenseEntity) {
        transaction.createExpenseItem(expenseItem)
    }
}