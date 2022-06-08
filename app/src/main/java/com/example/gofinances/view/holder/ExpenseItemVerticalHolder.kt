package com.example.gofinances.view.holder

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.gofinances.R
import com.example.gofinances.constants.GoFinancesConstants
import com.example.gofinances.view.fragments.ExpenseListFragment

@EpoxyModelClass
abstract class ExpenseItemVerticalHolder :
    EpoxyModelWithHolder<ExpenseItemVerticalHolder.VerticalHolder>() {

    @EpoxyAttribute
    lateinit var name: String

    @EpoxyAttribute
    lateinit var price: String

    @EpoxyAttribute
    lateinit var category: String

    @EpoxyAttribute
    lateinit var type: String

    @EpoxyAttribute
    lateinit var date: String

    @EpoxyAttribute
    lateinit var iconCategory: Drawable

    @EpoxyAttribute
    lateinit var context: Context

    override fun bind(holder: VerticalHolder) {
        holder.mTextName.text = name
        holder.mTextCategory.text = category
        holder.mTextDate.text = date
        holder.mImageCategory.setImageDrawable(iconCategory)
        holder.mImageCategory.setColorFilter(R.color.text_gray_color)
        setTypeCard(holder)
    }

    private fun setTypeCard(holder: VerticalHolder){
        if(type == GoFinancesConstants.IncomeAndOutcomeValues.INCOME_VALUE){
            holder.mTextPrice.text = "R$ $price"
            holder.mTextPrice.setTextColor(ContextCompat.getColor(context, R.color.success_color))
        }

        if(type == GoFinancesConstants.IncomeAndOutcomeValues.OUTCOME_VALUE){
            holder.mTextPrice.text = "- R$ $price"
            holder.mTextPrice.setTextColor(ContextCompat.getColor(context, R.color.warn_color))
        }
    }

    inner class VerticalHolder : EpoxyHolder() {
        lateinit var mTextName: TextView
        lateinit var mTextPrice: TextView
        lateinit var mTextCategory: TextView
        lateinit var mTextDate: TextView
        lateinit var mImageCategory: ImageView

        override fun bindView(itemView: View) {
            mTextName = itemView.findViewById(R.id.text_name)
            mTextPrice = itemView.findViewById(R.id.text_price)
            mTextCategory = itemView.findViewById(R.id.text_type_category)
            mTextDate = itemView.findViewById(R.id.text_date_item)
            mImageCategory = itemView.findViewById(R.id.image_type_category)
        }
    }

    override fun getDefaultLayout(): Int {
        return R.layout.item_card_vertical
    }
}