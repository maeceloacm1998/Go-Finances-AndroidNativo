package com.example.gofinances.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gofinances.R
import com.example.gofinances.provider.LoginRepositoryProvider
import com.example.gofinances.service.local.entity.LoginEntity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init banco local de login
        LoginRepositoryProvider.initialize(applicationContext)

        // TODO instalar a viewBinding
        // TODO fazer todo o processo da tela de login
    }
}