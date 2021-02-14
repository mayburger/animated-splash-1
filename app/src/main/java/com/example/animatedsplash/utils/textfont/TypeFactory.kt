package com.example.animatedsplash.utils.textfont

import android.content.Context
import android.graphics.Typeface

/**
 * Created by rujul on 2/5/2016.
 */
class TypeFactory internal constructor(context: Context) {

    private val BOLD = "fonts/Lato-Bold.ttf"
    private val ITALIC = "fonts/Lato-Bold.ttf"
    private val MEDIUM = "fonts/Lato-Bold.ttf"
    private val REGULAR = "fonts/Lato-Regular.ttf"
    private val BLACK = "fonts/Lato-Black.ttf"

    val bold: Typeface
    val italic: Typeface
    val medium: Typeface
    val black:Typeface
    val regular: Typeface

    init {
        bold = Typeface.createFromAsset(context.assets, BOLD)
        black = Typeface.createFromAsset(context.assets, BLACK)
        italic = Typeface.createFromAsset(context.assets, ITALIC)
        medium = Typeface.createFromAsset(context.assets, MEDIUM)
        regular = Typeface.createFromAsset(context.assets, REGULAR)
    }
}
