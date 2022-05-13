package com.example.gofinances.provider

import android.content.Context
import com.example.gofinances.service.local.LoginRepositoryModel
import com.example.gofinances.service.local.dao.LoginDAO
import com.example.gofinances.service.local.database.LoginDataBase
import com.example.gofinances.service.local.repository.LoginRepository

object LoginRepositoryProvider {
    private var transactionRepository: LoginRepositoryModel? = null

    fun transaction(): LoginRepositoryModel {
        return checkNotNull(transactionRepository) {
            "You can't access the transaction repository if you don't initialize it!"
        }
    }

    fun initialize(applicationContext: Context) {
        if (transactionRepository == null) {
            val db = LoginDataBase.getDataBase(applicationContext)
            transactionRepository = LoginRepository(db)
        }
    }
}