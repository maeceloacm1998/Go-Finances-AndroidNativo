package com.example.gofinances.view.controller

import android.content.Context
import com.airbnb.epoxy.EpoxyController
import com.example.gofinances.constants.GoFinancesConstants
import com.example.gofinances.provider.ExpenseProvider
import com.example.gofinances.service.local.entity.ExpenseEntity
import com.example.gofinances.view.model.ExpenseTotalModel

class ExpenseListHorizontalController : EpoxyController() {
    private val mExpenseTotalList: MutableList<ExpenseTotalModel> = arrayListOf()
    private lateinit var context: Context

    override fun buildModels() {
        TODO("Not yet implemented")
    }

    fun setData() {
        val incomeTotal = getTotalPerType(GoFinancesConstants.IncomeAndOutcomeValues.INCOME_VALUE)
        val outcomeTotal = getTotalPerType(GoFinancesConstants.IncomeAndOutcomeValues.OUTCOME_VALUE)

        val getLastIncomeDate = getLastDate(GoFinancesConstants.IncomeAndOutcomeValues.INCOME_VALUE)
        val getLastOutcomeDate = getLastDate(GoFinancesConstants.IncomeAndOutcomeValues.OUTCOME_VALUE)

        mExpenseTotalList.add(
            ExpenseTotalModel(
                GoFinancesConstants.IncomeAndOutcomeValues.INCOME_VALUE,
                incomeTotal,
                getLastIncomeDate
            )
        )

        mExpenseTotalList.add(
            ExpenseTotalModel(
                GoFinancesConstants.IncomeAndOutcomeValues.OUTCOME_VALUE,
                outcomeTotal,
                getLastOutcomeDate
            )
        )

//        requestModelBuild()
    }

    private fun getTotalPerType(type: String): Float {
        val getTypeList: List<ExpenseEntity> = ExpenseProvider.transaction()
            .getSpecificType(type)

        var total = 0.00
        if(getTypeList.isNotEmpty()){
            getTypeList.forEach { item ->
                total += item.price.toFloat()
            }
        }
        return total.toFloat()
    }

    private fun getLastDate(type: String): Long {
        val getTypeList: List<ExpenseEntity> = ExpenseProvider.transaction()
            .getSpecificType(type)
        var idReference = 0

        getTypeList.forEach {
            if (it.id > idReference) {
                idReference = it.id
            }
        }
        val s =""
        return getTypeList.find { it.id == idReference }?.dtCreated ?: 0
    }


    fun setContext(applicationContext: Context) {
        context = applicationContext
    }
}
