package com.example.gofinances.ui_components

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.gofinances.R
import com.example.gofinances.databinding.ItemTextInputCustomBinding

class TextInputCustom @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet?,
    defStyledAttr: Int = 0
) : ConstraintLayout(context, attr, defStyledAttr) {
    private var hint: String? = null

    private val binding: ItemTextInputCustomBinding = ItemTextInputCustomBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    init {
        setLayout(attr)
        refreshState()
    }

    private fun setLayout(attr: AttributeSet?) {
        attr?.let { attributeSet: AttributeSet ->
            val attributes =
                context.obtainStyledAttributes(attributeSet, R.styleable.TextInputCustom)

            setHint(attributes)

            attributes.recycle()
        }
    }

    private fun refreshState() {
        binding.textInputCustom.hint = hint
    }

    private fun setHint(attributes: TypedArray) {
        val hintResId =
            attributes.getResourceId(R.styleable.TextInputCustom_text_input_custom_hint, 0)
        if (hintResId != 0) {
            hint = context.getString(hintResId)
        }
    }
}