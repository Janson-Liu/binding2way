package ir.drax.binding2way

import android.util.Log
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter


/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 09/04/18
 */

class EditTextBindings {
    companion object InverseSpinnerBindings {

        @JvmStatic
        @BindingAdapter("android:text")
        fun EditText.bindObjectInText(value: Any?) {
            value?.let {
                if (tag == value) return
                tag = value
                setText(value.toString())
                // Set the cursor to the end of the text
//            setSelection(text.indexOf().length)
            }
        }

        @JvmStatic
        @InverseBindingAdapter(attribute = "android:text")
        fun EditText.getObjectFromBinding(): Int? {
            Log.e("getObjectFromBinding",text.toString())
//            Log.e("--------->",text.toString().toFloat().toString())
            val result=text.toString()
            /*return when(tag){
                is Float-> {
                    val position = text.indexOf(".")
                    setSelection(if (position>=0)position else length())
                    if(result.isEmpty())0f
                    else if (result == ".") 0f
                    else if (result == "-") -.0f
                    else result.toFloat()

                }
                is Double-> result.toDouble()
                is Int-> {
                    if(result.isEmpty()) 0
                    else if (result == "-") -0
                    else result.toInt()

                }
                else-> result
            }*/
            return 2
        }
    }


}