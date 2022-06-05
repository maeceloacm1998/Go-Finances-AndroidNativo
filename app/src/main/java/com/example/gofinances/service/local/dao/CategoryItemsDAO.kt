package com.example.gofinances.service.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gofinances.service.local.entity.CategoryItemsEntity

@Dao
interface CategoryItemsDAO {

    @Query("SELECT * FROM category_items_table")
    fun getAllCategoryItems(): List<CategoryItemsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createCategoryItems(categoryItem:CategoryItemsEntity)
}