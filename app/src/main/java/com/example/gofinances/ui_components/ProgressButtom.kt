package com.example.gofinances.ui_components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.gofinances.R
import com.example.gofinances.databinding.ItemProgressButtonBinding

class ProgressButtom @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet?,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attr, defStyleAttr) {
    private var title: String? = null
    private var loadingTitle: String? = null

    private var binding: ItemProgressButtonBinding = ItemProgressButtonBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    // Atualizacao de estado
    private var state: ProgressButtonState = ProgressButtonState.Normal
        set(value) {
            field = value
            refreshState()
        }

    // Funcoes ao iniciar a tela
    init {
        setLayout(attr)
        setNormal()
    }

    // Setando o layout da tela de acordo com os atributor
    private fun setLayout(attr: AttributeSet?) {
        attr?.let {
            val attributes = context.obtainStyledAttributes(it, R.styleable.ProgressButtom)

            setBackgroundResource(R.drawable.bg_progress_background)

            val titleResId =
                attributes.getResourceId(R.styleable.ProgressButtom_progress_button_title, 0)

            if (titleResId != 0) {
                title = context.getString(titleResId)
            }

            val loadingTitleResId =
                attributes.getResourceId(
                    R.styleable.ProgressButtom_progress_button_loading_title,
                    0
                )

            if (loadingTitleResId != 0) {
                loadingTitle = context.getString(loadingTitleResId)
            }

            attributes.recycle()
        }
    }

    // Funcao que mostra a atualizacao dos estados quando setados
    private fun refreshState() {
        isEnabled = state.isEnable
        isClickable = state.isEnable
        refreshDrawableState()

        binding.textTitle.run {
            isEnabled = state.isEnable
            isClickable = state.isEnable
        }

        binding.progressBottom.visibility = state.progressVisibility

        when(state){
            ProgressButtonState.Normal -> binding.textTitle.text = title
            ProgressButtonState.Loading -> binding.textTitle.text = loadingTitle
        }
    }

    fun setLoading(){
        state = ProgressButtonState.Loading
    }

    fun setNormal(){
        state = ProgressButtonState.Normal
    }

    sealed class ProgressButtonState(val isEnable: Boolean, val progressVisibility: Int) {
        object Normal : ProgressButtonState(true, View.GONE)
        object Loading : ProgressButtonState(false, View.VISIBLE)
    }
}