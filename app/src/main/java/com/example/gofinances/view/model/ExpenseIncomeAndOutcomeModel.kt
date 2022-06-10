package com.example.gofinances.view.model

data class ExpenseIncomeAndOutcomeModel(
    val type: String,
    val iconType: Int,
    val priceTotal: Float,
    val lastDate: Long
)