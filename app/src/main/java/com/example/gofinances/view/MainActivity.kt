package com.example.gofinances.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.gofinances.R
import com.example.gofinances.databinding.ActivityMainBinding
import com.example.gofinances.provider.CategoryItemsProvider
import com.example.gofinances.provider.ExpenseProvider
import com.example.gofinances.provider.LoginRepositoryProvider
import com.example.gofinances.viewmodel.LoginViewModel


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mLoginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mLoginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Init banco local de login
        LoginRepositoryProvider.initialize(applicationContext)
        CategoryItemsProvider.initialize(applicationContext)
        ExpenseProvider.initialize(applicationContext)

        observer()
        listeners()

    }

    override fun onClick(v: View) {
        val id = v.id

        if (id == R.id.button_register) {
            register()
        }

        if (id == R.id.button_login) {
            login()
        }
    }

    private fun observer() {
        mLoginViewModel.loginSuccess.observe(this) {
            if (it) {
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                Toast.makeText(this, "deu login, nao", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun listeners() {
        binding.buttonRegister.setOnClickListener(this)
        binding.buttonLogin.setOnClickListener(this)
    }

    private fun login() {
        val email = binding.inputEmail.editText?.text.toString()
        val password = binding.inputPassword.editText?.text.toString()

        mLoginViewModel.login(email,password)
    }

    private fun register() {

    }

}