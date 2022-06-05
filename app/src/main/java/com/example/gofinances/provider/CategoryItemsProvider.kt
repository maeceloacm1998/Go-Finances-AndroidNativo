package com.example.gofinances.provider

import android.content.Context
import com.example.gofinances.R
import com.example.gofinances.service.local.database.CategoryItemsDataBase
import com.example.gofinances.service.local.entity.CategoryItemsEntity
import com.example.gofinances.service.local.model.CategoryItemsModel
import com.example.gofinances.service.local.repository.CategoryItemsRepository

object CategoryItemsProvider {
    private var categoryItemsTransaction: CategoryItemsModel? = null

    fun transaction(): CategoryItemsModel {
        return checkNotNull(categoryItemsTransaction) {
            "You can't access the transaction repository if you don't initialize it!"
        }
    }

    fun initialize(applicationContext: Context) {
        if (categoryItemsTransaction == null) {
            val db = CategoryItemsDataBase.getDataBase(applicationContext)
            categoryItemsTransaction = CategoryItemsRepository(db)
        }
    }

    fun getData(): List<CategoryItemsEntity> {
        return listOf(
            CategoryItemsEntity().apply {
                this.icon = R.drawable.ic_shopping_bag_24
                this.name = "Compras"
            },
            CategoryItemsEntity().apply {
                this.icon = R.drawable.ic_baseline_coffee_24
                this.name = "Alimentação"
            },
            CategoryItemsEntity().apply {
                this.icon = R.drawable.ic_dolar_24
                this.name = "Salario"
            },
            CategoryItemsEntity().apply {
                this.icon = R.drawable.ic_car_24
                this.name = "Carro"
            },
            CategoryItemsEntity().apply {
                this.icon = R.drawable.ic_favorite_24
                this.name = "Lazer"
            },
            CategoryItemsEntity().apply {
                this.icon = R.drawable.ic_baseline_menu_book_24
                this.name = "Estudo"
            }
        )
    }
}