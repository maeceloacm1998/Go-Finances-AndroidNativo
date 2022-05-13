package com.example.gofinances.service.local

import com.example.gofinances.service.local.entity.LoginEntity

interface LoginRepositoryModel {
    fun createUser(user: LoginEntity)

    fun getUser(email: String,password:String): LoginEntity
}