package com.example.gofinances.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.gofinances.provider.LoginRepositoryProvider

class LoginViewModel(application: Application): AndroidViewModel(application) {

    private var mLoginSuccess = MutableLiveData<Boolean>().apply {
        value = false
    }
    val loginSuccess = mLoginSuccess

    fun login(email:String,password:String){
        val getUser = LoginRepositoryProvider.transaction().getUser(email, password)

        if(getUser != null){
            mLoginSuccess.value = true
        }
    }

}