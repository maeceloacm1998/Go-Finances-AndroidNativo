package com.example.gofinances.view.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.gofinances.R
import com.example.gofinances.constants.GoFinancesConstants
import com.example.gofinances.databinding.FragmentRegisterExpenseBinding
import com.example.gofinances.provider.CategoryItemsProvider
import com.example.gofinances.service.local.ServicePreferences
import com.example.gofinances.view.CategoryActivity

class RegisterExpenseFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: com.example.gofinances.databinding.FragmentRegisterExpenseBinding
    private var categoryActivity = CategoryActivity()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterExpenseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.inputPrice.setInputType(GoFinancesConstants.InputTypes.NUMBER)
        setServicePreferences(GoFinancesConstants.SharedPreferences.CATEGORY_SELECTED, "")
        setIncomeState()
        loadCategoryItems()
        listeners()
    }

    override fun onStart() {
        super.onStart()
        val categoryItemSelected =
            activity?.applicationContext?.let { ServicePreferences(it).getString("item_selected") }

        if (!categoryItemSelected.isNullOrBlank()) {
            binding.textCategory.text = categoryItemSelected
        }
    }

    private fun listeners() {
        goToCategoryFragment()
        binding.buttonSubmit.setOnClickListener(this)
        binding.buttonIncome.setOnClickListener(this)
        binding.buttonOutcome.setOnClickListener(this)
    }

    private fun loadCategoryItems() {
        val listCategoryItems = CategoryItemsProvider.transaction().getAllCategoryItems()
        val categoryItems = CategoryItemsProvider.getData()

        if (listCategoryItems.isEmpty()) {
            for (item in categoryItems) {
                CategoryItemsProvider.transaction().createCategoryItems(item)
            }
        }
    }

    private fun setIncomeState() {
        if (!binding.buttonIncome.STATE_CLICK) {
            binding.buttonIncome.setClickState()
            stateIncomeOrOutcome = GoFinancesConstants.IncomeAndOutcomeValues.INCOME_VALUE
            binding.buttonOutcome.setNormalState()
        } else {
            stateIncomeOrOutcome = ""
            binding.buttonIncome.setNormalState()
        }
    }

    private fun setOutcomeState() {
        if (!binding.buttonOutcome.STATE_CLICK) {
            binding.buttonOutcome.setClickState()
            stateIncomeOrOutcome = GoFinancesConstants.IncomeAndOutcomeValues.OUTCOME_VALUE
            binding.buttonIncome.setNormalState()
        } else {
            binding.buttonOutcome.setNormalState()
            stateIncomeOrOutcome = null
        }
    }

    private fun setServicePreferences(key: String, value: String) {
        context?.let { it1 ->
            ServicePreferences(it1).setStore(key, value)
        }
    }

    private fun goToCategoryFragment() {
        binding.buttonCategory.setOnClickListener {
            openActivityCategory(categoryActivity)
        }
    }

    private fun openActivityCategory(activity: Activity) {
        startActivity(Intent(context, activity::class.java))
    }

    private fun handleSubmitButton() {
        nameValue = binding.inputName.getEditText()?.text.toString()
        priceValue = binding.inputPrice.getEditText()?.text.toString()
        categoryValue =
            context?.let { ServicePreferences(it).getString(GoFinancesConstants.SharedPreferences.CATEGORY_SELECTED) }

        val isValidation = validationComponents()

        if (isValidation) {
            onSubmit()
        }
    }

    private fun validationComponents(): Boolean {
        var isValidation = false

        if (nameValue.isNullOrBlank()) {
            binding.inputName.setError(GoFinancesConstants.RegisterExpense.ERROR_NAME_VALUE)
        }

        if (priceValue.isNullOrBlank()) {
            binding.inputPrice.setError(GoFinancesConstants.RegisterExpense.ERROR_PRICE_VALUE)
        }

        if (categoryValue.isNullOrBlank()) {
            Toast.makeText(
                context,
                GoFinancesConstants.RegisterExpense.ERROR_CATEGORY,
                Toast.LENGTH_LONG
            ).show()
        }

        if (!nameValue.isNullOrBlank() && !priceValue.isNullOrBlank() && !categoryValue.isNullOrBlank()) {
            isValidation = true
        }

        return isValidation
    }

    private fun onSubmit() {
        Toast.makeText(
            context,
            "sucesso",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_submit) {
            handleSubmitButton()
        }

        if (v.id == R.id.button_income) {
            setIncomeState()
        }

        if (v.id == R.id.button_outcome) {
            setOutcomeState()
        }
    }

    companion object {
        var nameValue: String? = null
        var priceValue: String? = null
        var stateIncomeOrOutcome: String? = null
        var categoryValue: String? = null
    }
}