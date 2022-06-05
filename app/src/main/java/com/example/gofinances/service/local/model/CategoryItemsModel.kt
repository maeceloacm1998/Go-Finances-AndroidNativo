package com.example.gofinances.service.local.model

import com.example.gofinances.service.local.entity.CategoryItemsEntity

interface CategoryItemsModel {
    fun getAllCategoryItems(): List<CategoryItemsEntity>

    fun createCategoryItems(categoryItem: CategoryItemsEntity)
}