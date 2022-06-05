package com.example.gofinances.view.holder

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.gofinances.R
import com.example.gofinances.service.local.ServicePreferences
import com.google.android.material.internal.ContextUtils.getActivity

@EpoxyModelClass
abstract class CategoryListHolder : EpoxyModelWithHolder<CategoryListHolder.CategoryHolder>() {

    @EpoxyAttribute
    lateinit var name: String

    @EpoxyAttribute
    lateinit var icon: Drawable

    @EpoxyAttribute
    lateinit var backgroundItem: Drawable

    @SuppressLint("RestrictedApi")
    override fun bind(holder: CategoryHolder) {
        holder.mName.text = name
        holder.mIcon.setImageDrawable(icon)

        holder.mContainerCategory.setBackgroundDrawable(backgroundItem)

        holder.mContainerCategory.setOnClickListener {
            ServicePreferences(it.context).setStore("item_selected", name)
            it.setBackgroundDrawable(backgroundItem)
            getActivity(it.context)?.onBackPressed()
        }
    }

    inner class CategoryHolder : EpoxyHolder() {
        lateinit var mContainerCategory: ConstraintLayout
        lateinit var mName: TextView
        lateinit var mIcon: ImageView

        override fun bindView(itemView: View) {
            mContainerCategory = itemView.findViewById(R.id.container_item_category)
            mName = itemView.findViewById(R.id.text_category_name)
            mIcon = itemView.findViewById(R.id.icon_item_category)
        }
    }

    override fun getDefaultLayout(): Int {
        return R.layout.item_category_list
    }
}