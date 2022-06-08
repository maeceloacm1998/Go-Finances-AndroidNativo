package com.example.gofinances.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.gofinances.R
import com.example.gofinances.databinding.ActivityHomeBinding
import com.example.gofinances.view.fragments.ExpenseListFragment
import com.example.gofinances.view.fragments.RegisterExpenseFragment

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding
    private val expenseListFragment = ExpenseListFragment()
    private val registerItemFragment = RegisterExpenseFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listeners()
        events()
    }

    private fun listeners() {
        binding.menuList.setOnClickListener(this)
        binding.menuSignup.setOnClickListener(this)
        binding.menuResume.setOnClickListener(this)
    }

    private fun events() {
        setFragmentView(expenseListFragment)
        setMenuItemColor("menu_list")
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.menu_list -> {
                setFragmentView(expenseListFragment)
                setMenuItemColor("menu_list")
            }
            R.id.menu_signup -> {
                setFragmentView(registerItemFragment)
                setMenuItemColor("menu_signup")
            }
            R.id.menu_resume -> {
                setMenuItemColor("menu_resume")
            }
        }
    }

    private fun setFragmentView(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(R.id.frame_layout, fragment)
            .commit()
    }

    private fun setMenuItemColor(typeItem: String) {
        setDefaultColor()

        when (typeItem) {
            "menu_list" -> {
                binding.textIconList.setTextColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.secondary_color
                    )
                )
                binding.iconList.setColorFilter(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.secondary_color
                    )
                )
            }
            "menu_signup" -> {
                binding.textIconSignup.setTextColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.secondary_color
                    )
                )
                binding.iconSignup.setColorFilter(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.secondary_color
                    )
                )
            }
            "menu_resume" -> {
                binding.textIconResume.setTextColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.secondary_color
                    )
                )
                binding.iconResume.setColorFilter(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.secondary_color
                    )
                )
            }
        }
    }

    private fun setDefaultColor() {
        binding.textIconList.setTextColor(
            ContextCompat.getColor(
                applicationContext,
                R.color.title_color
            )
        )
        binding.iconList.setColorFilter(
            ContextCompat.getColor(
                applicationContext,
                R.color.title_color
            )
        )

        binding.textIconSignup.setTextColor(
            ContextCompat.getColor(
                applicationContext,
                R.color.title_color
            )
        )
        binding.iconSignup.setColorFilter(
            ContextCompat.getColor(
                applicationContext,
                R.color.title_color
            )
        )

        binding.textIconResume.setTextColor(
            ContextCompat.getColor(
                applicationContext,
                R.color.title_color
            )
        )
        binding.iconResume.setColorFilter(
            ContextCompat.getColor(
                applicationContext,
                R.color.title_color
            )
        )
    }
}