package com.example.gofinances.view.controller

import android.content.Context
import com.airbnb.epoxy.EpoxyController
import com.example.gofinances.constants.GoFinancesConstants
import com.example.gofinances.provider.ExpenseProvider
import com.example.gofinances.service.local.entity.ExpenseEntity
import com.example.gofinances.service.local.model.PricePerTypeModel
import com.example.gofinances.view.holder.expenseItemHorizontalHolder
import com.example.gofinances.view.model.ExpenseIncomeAndOutcomeModel
import com.example.gofinances.view.model.ExpenseTotalModel
import java.text.SimpleDateFormat
import java.util.*

class ExpenseListHorizontalController : EpoxyController() {
    private lateinit var mExpenseIncomeItem: ExpenseIncomeAndOutcomeModel
    private lateinit var mExpenseOutcomeItem: ExpenseIncomeAndOutcomeModel
    private lateinit var mExpenseTotalItem: ExpenseTotalModel

    private lateinit var context: Context

    override fun buildModels() {
        mExpenseIncomeItem.let { item ->
            expenseItemHorizontalHolder {
                id(item.priceTotal)
                type(item.type)
                iconType(item.iconType)
                lastDate(item.lastDate)
                price(item.priceTotal)
                context(context)
            }
        }

        mExpenseOutcomeItem.let { item ->
            expenseItemHorizontalHolder {
                id(item.priceTotal)
                type(item.type)
                iconType(item.iconType)
                lastDate(item.lastDate)
                price(item.priceTotal)
                context(context)
            }
        }

        mExpenseTotalItem.let { item ->
            expenseItemHorizontalHolder {
                id(item.priceTotal)
                type(item.type)
                iconType(item.iconType)
                price(item.priceTotal)
                context(context)
            }
        }
    }

    fun setData() {
        val incomeTotal = getTotalPerType(GoFinancesConstants.IncomeAndOutcomeValues.INCOME_VALUE)
        val outcomeTotal = getTotalPerType(GoFinancesConstants.IncomeAndOutcomeValues.OUTCOME_VALUE)

        val getLastIncomeDate = getLastDate(GoFinancesConstants.IncomeAndOutcomeValues.INCOME_VALUE)
        val getLastOutcomeDate =
            getLastDate(GoFinancesConstants.IncomeAndOutcomeValues.OUTCOME_VALUE)

        mExpenseIncomeItem =
            ExpenseIncomeAndOutcomeModel(
                GoFinancesConstants.IncomeAndOutcomeValues.INCOME_VALUE,
                GoFinancesConstants.IncomeAndOutcomeValues.INCOME_ICON_VALUE,
                incomeTotal,
                getLastIncomeDate
            )


        mExpenseOutcomeItem =
            ExpenseIncomeAndOutcomeModel(
                GoFinancesConstants.IncomeAndOutcomeValues.OUTCOME_VALUE,
                GoFinancesConstants.IncomeAndOutcomeValues.OUTCOME_ICON_VALUE,
                outcomeTotal,
                getLastOutcomeDate
            )


        mExpenseTotalItem =
            ExpenseTotalModel(
                GoFinancesConstants.IncomeAndOutcomeValues.TOTAL_VALUE,
                GoFinancesConstants.IncomeAndOutcomeValues.TOTAL_ICON_VALUE,
                getTotalValue(),
                getIntervalDate()
            )
        requestModelBuild()
    }

    private fun getTotalPerType(type: String): Float {
        val getTypeList: List<ExpenseEntity> = ExpenseProvider.transaction()
            .getSpecificType(type)

        var total = 0.00
        if (getTypeList.isNotEmpty()) {
            getTypeList.forEach { item ->
                total += item.price.toFloat()
            }
        }
        return total.toFloat()
    }

    private fun getTotalValue(): Float {

        val totalPriceIncome =
            ExpenseProvider.transaction().getPricePerType(GoFinancesConstants.IncomeAndOutcomeValues.INCOME_VALUE)


        val totalPriceOutcome =
            ExpenseProvider.transaction().getPricePerType(GoFinancesConstants.IncomeAndOutcomeValues.OUTCOME_VALUE)

        return totalPriceIncome - totalPriceOutcome
    }

    private fun getIntervalDate(): String {
        val getFirstDate = ExpenseProvider.transaction().getFirstRegister()
        val getLastDate = ExpenseProvider.transaction().getLastRegister()
        val patternDay = getPatternDate(GoFinancesConstants.FormatDate.DAY)
        val patternDateInFull = getPatternDate(GoFinancesConstants.FormatDate.DATE_IN_FULL)

        return "${patternDay.format(Date(getFirstDate))} à ${patternDateInFull.format(Date(getLastDate))}"
    }

    private fun getPatternDate(pattern: String) =
        SimpleDateFormat(pattern, Locale.getDefault())

    private fun getLastDate(type: String): Long {
        val getTypeList: List<ExpenseEntity> = ExpenseProvider.transaction()
            .getSpecificType(type)
        var idReference = 0

        getTypeList.forEach {
            if (it.id > idReference) {
                idReference = it.id
            }
        }
        return getTypeList.find { it.id == idReference }?.dtCreated ?: 0
    }

    fun setContext(applicationContext: Context) {
        context = applicationContext
    }
}

