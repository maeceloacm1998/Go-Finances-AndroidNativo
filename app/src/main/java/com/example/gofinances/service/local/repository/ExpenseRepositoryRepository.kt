package com.example.gofinances.service.local.repository

import com.example.gofinances.service.local.database.ExpenseDataBase
import com.example.gofinances.service.local.entity.ExpenseEntity
import com.example.gofinances.service.local.model.ExpenseRepositoryModel
import com.example.gofinances.service.local.model.PricePerTypeModel

class ExpenseRepositoryRepository(private val database: ExpenseDataBase): ExpenseRepositoryModel {
    private val transaction get() = database.expenseDAO()

    override fun getAllExpenseItems(): List<ExpenseEntity> {
        return transaction.getAllExpenseItems()
    }

    override fun createExpenseItem(expenseItem: ExpenseEntity) {
        transaction.createExpenseItem(expenseItem)
    }

    override fun getSpecificType(type: String): List<ExpenseEntity> {
        return transaction.getSpecificType(type)
    }

    override fun getPricePerType(type: String): Float {
        val prices: List<String> = transaction.getPricePerType(type)
        var totalPrice = 0F;

        prices.forEach { price ->
            totalPrice += price.toFloat()
        }

        return totalPrice
    }

    override fun getFirstRegister(): Long {
        return transaction.getFirstRegister()
    }

    override fun getLastRegister(): Long {
        return transaction.getLastRegister()
    }
}