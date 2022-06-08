package com.example.gofinances.view.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gofinances.constants.GoFinancesConstants
import com.example.gofinances.databinding.FragmentExpenseListBinding
import com.example.gofinances.provider.ExpenseProvider
import com.example.gofinances.view.controller.ExpenseListHorizontalController
import com.example.gofinances.view.controller.ExpenseListVerticalController
import java.text.SimpleDateFormat
import java.util.*

class ExpenseListFragment : Fragment() {
    private lateinit var binding: FragmentExpenseListBinding
    private val expenseListVerticalController = ExpenseListVerticalController()
    private val expenseListHorizontalController = ExpenseListHorizontalController()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExpenseListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvListVertical.apply {
            setController(expenseListVerticalController)
            layoutManager = LinearLayoutManager(context)
        }

        binding.rvCardHorizontal.apply {
            setController(expenseListHorizontalController)
            layoutManager = LinearLayoutManager(context)
        }

        context?.let { expenseListVerticalController.setContext(it) }
        context?.let { expenseListHorizontalController.setContext(it) }

        expenseListVerticalController.setData(ExpenseProvider.transaction().getAllExpenseItems())
        expenseListHorizontalController.setData()
    }

    fun formatDate(date: Date): String {
        val pattern =
            SimpleDateFormat(GoFinancesConstants.FormatDate.SIMPLE_DATE, Locale.getDefault())
        return pattern.format(date)
    }
}