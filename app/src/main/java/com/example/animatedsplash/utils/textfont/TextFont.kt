package com.example.animatedsplash.utils.textfont

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.animatedsplash.base.BaseApplication
import com.example.animatedsplash.R

class TextFont(context: Context, attrs: AttributeSet) : AppCompatTextView(context, attrs) {

    init {
        val array = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.TextFont,
                0, 0)
        val typefaceType: Int
        val textString: String
        try {
            typefaceType = array.getInteger(R.styleable.TextFont_typeface, 0)
        } finally {
            array.recycle()
        }

        setCustomFont(typefaceType)
        includeFontPadding = false
    }

    fun setCustomFont(typefaceType: Int): Boolean {
        if (BaseApplication.getApp().getTypeFace(typefaceType) != null) {
            typeface = BaseApplication.getApp().getTypeFace(typefaceType)
            return true
        }
        return false
    }
}