package com.example.gofinances.service.local

import android.content.Context
import android.content.SharedPreferences

class ServicePreferences(context: Context) {
    private val shared: SharedPreferences =
        context.getSharedPreferences("GO_FINANCES", Context.MODE_PRIVATE)

    fun setStore(key: String, value: String) {
        shared.edit().putString(key, value).apply()
    }

    fun getString(key: String): String {
        return shared.getString(key, "") ?: ""
    }
}