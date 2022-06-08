package com.example.gofinances.view.controller

import com.airbnb.epoxy.EpoxyController
import com.example.gofinances.service.local.entity.ExpenseEntity

class ExpenseListHorizontalController: EpoxyController() {
    private val mExpenseTotalList: MutableList<String> = arrayListOf()

    override fun buildModels() {
        TODO("Not yet implemented")
    }

    fun setData(expenseList: List<ExpenseEntity>){

    }

    private fun getIncomeTotal(){

    }

    private fun getOutcomeTotal(){

    }

}