package com.example.gofinances.provider

import android.content.Context
import com.example.gofinances.service.local.database.ExpenseDataBase
import com.example.gofinances.service.local.model.ExpenseRepositoryModel
import com.example.gofinances.service.local.repository.ExpenseRepositoryRepository

object ExpenseProvider {
    private var transactionRepository: ExpenseRepositoryModel? = null

    fun transaction(): ExpenseRepositoryModel {
        return checkNotNull(transactionRepository) {
            "You can't access the transaction repository if you don't initialize it!"
        }
    }

    fun initialize(applicationContext: Context) {
        if (transactionRepository == null) {
            val db = ExpenseDataBase.getDataBase(applicationContext)
            transactionRepository = ExpenseRepositoryRepository(db)
        }
    }
}