package com.example.gofinances.view.holder

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.gofinances.R
import com.example.gofinances.constants.GoFinancesConstants
import com.google.android.material.card.MaterialCardView
import java.text.SimpleDateFormat
import java.util.*

@EpoxyModelClass
abstract class ExpenseItemHorizontalHolder :
    EpoxyModelWithHolder<ExpenseItemHorizontalHolder.SectionHolder>() {

    @EpoxyAttribute
    lateinit var context: Context

    @EpoxyAttribute
    lateinit var type: String

    @EpoxyAttribute
    lateinit var intervalDate: String

    @EpoxyAttribute
    var iconType: Int = 0

    @EpoxyAttribute
    var price: Float = 0.0F

    @EpoxyAttribute
    var lastDate: Long = 0



    override fun bind(holder: SectionHolder) {
        setType(holder)
        setMargin(0, 0, 35, 0, holder)
        holder.mPrice.text = "R$ $price"
    }

    private fun setType(holder: SectionHolder) {
        if (type == GoFinancesConstants.IncomeAndOutcomeValues.INCOME_VALUE) {
            holder.mType.text = context.getString(R.string.income_text)
            holder.mIconType.setImageDrawable(ContextCompat.getDrawable(context, iconType))
            setLastDate(R.string.income_text,holder)
        }

        if (type == GoFinancesConstants.IncomeAndOutcomeValues.OUTCOME_VALUE) {
            holder.mType.text = context.getString(R.string.outcome_text)
            holder.mIconType.setImageDrawable(ContextCompat.getDrawable(context, iconType))
            setLastDate(R.string.outcome_text,holder)
        }
    }

    private fun setLastDate(type: Int ,holder: SectionHolder) {
        val pattern =
            SimpleDateFormat(GoFinancesConstants.FormatDate.DATE_IN_FULL, Locale.getDefault())

        holder.mLastDate.text = "Última ${context.getString(type)} dia ${pattern.format(Date(lastDate))}"
    }

    private fun setMargin(left: Int, top: Int, right: Int, bottom: Int, holder: SectionHolder) {
        val param = holder.mContainerCard.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(left, top, right, bottom)
        holder.mContainerCard.layoutParams = param
    }

    inner class SectionHolder : EpoxyHolder() {
        lateinit var mType: TextView
        lateinit var mIconType: ImageView
        lateinit var mPrice: TextView
        lateinit var mLastDate: TextView
        lateinit var mContainerCard: MaterialCardView

        override fun bindView(itemView: View) {
            mType = itemView.findViewById(R.id.text_type)
            mIconType = itemView.findViewById(R.id.icon_type)
            mPrice = itemView.findViewById(R.id.text_price)
            mLastDate = itemView.findViewById(R.id.text_last_date)
            mContainerCard = itemView.findViewById(R.id.container_card)
        }
    }

    override fun getDefaultLayout(): Int {
        return R.layout.item_card_horizontal
    }
}