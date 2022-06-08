package com.example.gofinances.constants

class GoFinancesConstants {
    object SharedPreferences {
        const val CATEGORY_SELECTED = "item_selected"
        const val ICON_CATEGORY_SELECTED = "icon_item_selected"
    }

    object IncomeAndOutcomeValues {
        const val INCOME_VALUE = "income"
        const val OUTCOME_VALUE = "outcome"
    }

    object RegisterExpense {
        const val ERROR_NAME_VALUE = "Nome é um campo obrigatorio."
        const val ERROR_PRICE_VALUE = "Preco é um campo obrigatorio."
        const val ERROR_CATEGORY = "Selecione uma categoria"
    }

    object InputTypes {
        const val NUMBER = 0x00000002
        const val NUMBER_DECIMAL = 0x00002002
        const val PHONE = 0x00000003
        const val PASSWORD = 0x00000081
        const val TEXT = 0x00002001
    }

    object FormatDate {
        const val SIMPLE_DATE = "dd/MM/yyyy"
    }

}