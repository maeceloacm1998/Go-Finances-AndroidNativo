package com.example.gofinances.service.local.repository

import com.example.gofinances.service.local.database.CategoryItemsDataBase
import com.example.gofinances.service.local.entity.CategoryItemsEntity
import com.example.gofinances.service.local.model.CategoryItemsModel

class CategoryItemsRepository(private val database: CategoryItemsDataBase) : CategoryItemsModel {
    private val transaction get() = database.categoryItemsDAO()

    override fun getAllCategoryItems(): List<CategoryItemsEntity> {
        return transaction.getAllCategoryItems()
    }

    override fun createCategoryItems(categoryItem: CategoryItemsEntity) {
        transaction.createCategoryItems(categoryItem)
    }
}