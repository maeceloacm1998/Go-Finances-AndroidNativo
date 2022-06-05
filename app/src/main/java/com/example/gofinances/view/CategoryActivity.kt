package com.example.gofinances.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofinances.databinding.ActivityCategoryBinding
import com.example.gofinances.provider.CategoryItemsProvider
import com.example.gofinances.service.local.entity.CategoryItemsEntity
import com.example.gofinances.view.controller.CategoryListController

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding
    private val controller = CategoryListController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initController()
    }

    private fun initController() {
        binding.rvCategory.apply {
            setController(controller)
            layoutManager = LinearLayoutManager(context)
        }

        applicationContext?.let { controller.setContext(it) }

        val data: List<CategoryItemsEntity> =
            CategoryItemsProvider.transaction().getAllCategoryItems()
        controller.setData(data)
    }
}