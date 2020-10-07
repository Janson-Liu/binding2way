package ir.drax.binding2way

import android.util.Log
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter


/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 09/04/18
 */

@BindingAdapter("android:text")
fun EditText.bindObjectInText(value: Any?) {
    value?.let {
        if (value!=tag) { // Store the original value
            tag = value   // To prevent duplicate/extra modification

            if (value is Float)// Cast float types to 1 float number
                setText(String.format("%1f", value))
            else
                setText(value.toString())
        }
    }
}

@InverseBindingAdapter(attribute = "android:text")
fun EditText.getFloatFromBinding(): Float? {
    val result=text.toString()

    return result.toFloat()
}
@InverseBindingAdapter(attribute = "android:text")
fun EditText.getIntFromBinding(): Int? {
    val result=text.toString()

    return result.toInt()
}