package com.example.gofinances.ui_components

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.example.gofinances.R
import com.example.gofinances.databinding.ItemButtonSelectIncomeAndOutcomeBinding

class ButtonSelectIncomeAndOutcome @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet?,
    defStyledAttr: Int = 0
) : CardView(context, attr, defStyledAttr) {
    var STATE_CLICK = false

    private var title: String = "default value"
    private var icon: Int = 0
    private var enableColor: Int = 0
    private var disableColor: Int = 0


    private var binding: ItemButtonSelectIncomeAndOutcomeBinding =
        ItemButtonSelectIncomeAndOutcomeBinding.inflate(
            LayoutInflater.from(context), this, true
        )

    init {
        setStyle(attr)
    }

    private fun setStyle(attr: AttributeSet?) {
        attr?.let { attributeSet: AttributeSet ->
            var attribute = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.ButtonSelectIncomeAndOutcome
            )

            getAttribute(attribute)

            attribute.recycle()
        }
    }

    private fun getAttribute(attribute: TypedArray) {
        val isIncomeResId = attribute.getBoolean(
            R.styleable.ButtonSelectIncomeAndOutcome_isIncome, false
        )

        val isOutcomeResId = attribute.getBoolean(
            R.styleable.ButtonSelectIncomeAndOutcome_isOutcome, false
        )

        if (isIncomeResId) {
            title = "Income"
            icon = R.drawable.ic_arrow_up_30
            enableColor = R.drawable.bg_border_green
            disableColor = R.drawable.bg_border_gray
            setNormalState()
        }

        if (isOutcomeResId) {
            title = "Outcome"
            icon = R.drawable.ic_arrow_down_30
            enableColor = R.drawable.bg_border_red
            disableColor = R.drawable.bg_border_gray
            setNormalState()
        }

    }

    fun setNormalState() {
        binding.containerButton.setBackgroundDrawable(resources.getDrawable(disableColor))
        binding.imageType.setImageDrawable(resources.getDrawable(icon))
        binding.textTypeButton.text = title
        STATE_CLICK = false
    }

    fun setClickState() {
        binding.containerButton.setBackgroundDrawable(resources.getDrawable(enableColor))
        STATE_CLICK = true
    }
}