package com.example.gofinances.view.controller

import android.content.Context
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.EpoxyController
import com.example.gofinances.service.local.entity.ExpenseEntity
import com.example.gofinances.view.fragments.ExpenseListFragment
import com.example.gofinances.view.holder.expenseItemVerticalHolder
import java.util.*

class ExpenseListVerticalController : EpoxyController() {
    private val mExpenseList: MutableList<ExpenseEntity> = arrayListOf()
    private lateinit var context: Context

    override fun buildModels() {
       mExpenseList.forEach {
            expenseItemVerticalHolder {
                id(it.id)
                name(it.name)
                price(it.price.toFloat().toString())
                type(it.type)
                context(context)
                date(ExpenseListFragment().formatDate(Date(it.dtCreated)))
                category(it.category)
                iconCategory(ContextCompat.getDrawable(context, it.iconCategory))
            }
       }
    }

    fun setData(expenseList: List<ExpenseEntity>) {
        expenseList.forEach { item ->
            mExpenseList.add(item)
        }
        requestModelBuild()
    }

    fun setContext(applicationContext: Context) {
        context = applicationContext
    }
}