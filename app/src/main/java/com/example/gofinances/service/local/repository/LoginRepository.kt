package com.example.gofinances.service.local.repository

import com.example.gofinances.service.local.model.LoginRepositoryModel
import com.example.gofinances.service.local.database.LoginDataBase
import com.example.gofinances.service.local.entity.LoginEntity

class LoginRepository(private val database: LoginDataBase): LoginRepositoryModel {
    private val transactionDao get() = database.loginDAO()

    override fun createUser(user: LoginEntity){
        return transactionDao.createUser(user)
    }

    override fun getUser(email:String,password:String): LoginEntity {
        return transactionDao.getUser(email, password)
    }
}