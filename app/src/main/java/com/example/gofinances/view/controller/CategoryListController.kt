package com.example.gofinances.view.controller

import android.content.Context
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.EpoxyController
import com.example.gofinances.R
import com.example.gofinances.service.local.ServicePreferences
import com.example.gofinances.service.local.entity.CategoryItemsEntity
import com.example.gofinances.view.holder.categoryListHolder

class CategoryListController : EpoxyController() {
    private var listCategoryItems: List<CategoryItemsEntity> = listOf()
    private lateinit var context: Context

    override fun buildModels() {
        listCategoryItems.forEach { item ->
            val categoryItemSelected = ServicePreferences(context).getString("item_selected")

            if (categoryItemSelected == item.name) {
                categoryListHolder {
                    id(item.id)
                    name(item.name)
                    icon(ContextCompat.getDrawable(context, item.icon))
                    iconValue(item.icon)
                    backgroundItem(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.bg_border_item_category_select
                        )
                    )
                }
            } else {
                categoryListHolder {
                    id(item.id)
                    name(item.name)
                    icon(ContextCompat.getDrawable(context, item.icon))
                    iconValue(item.icon)
                    backgroundItem(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.bg_border_item_category
                        )
                    )
                }
            }

        }
    }

    fun setData(categoryItems: List<CategoryItemsEntity>) {
        listCategoryItems = categoryItems
        requestModelBuild()
    }

    fun setContext(applicationContext: Context) {
        context = applicationContext
    }
}