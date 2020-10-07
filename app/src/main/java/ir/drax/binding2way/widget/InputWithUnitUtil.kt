package ir.drax.binding2way.widget

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.*


open class InputWithUnitUtil {


    @BindingAdapter(value = ["textAttrChanged"])
    fun InputWithUnit.setListener(textAttrChanged: InverseBindingListener?) {
        if (textAttrChanged != null) {
            binding.etValue.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    p0?.let {
                        if (it.isNotEmpty())
                            textAttrChanged.onChange()
                    }

                }
            })
        }
    }

    @BindingAdapter("text")
    fun InputWithUnit.setText(newValue: Any?) {
        newValue?.let {
            setValue(newValue)
        }
    }

    companion object EntryWithUnitUtil {

        @JvmStatic
        @InverseBindingAdapter(attribute = "text")
        fun InputWithUnit.getIntText(): Int? {

            value.value?.let {
                return when {
                    it.isEmpty() -> 0
                    it == "-" -> -0
                    else -> it.toInt()
                }
            }
            return 0
        }

        @JvmStatic
        @InverseBindingAdapter(attribute = "text")
        fun InputWithUnit.getFloatText(): Float? {
            value.value?.let {
                return when {
                    it.isEmpty() -> 0f
                    it == "." -> 0f
                    it == "-" -> -.0f
                    else -> it.toFloat()
                }
            }
            return 0f
        }

    }
}
