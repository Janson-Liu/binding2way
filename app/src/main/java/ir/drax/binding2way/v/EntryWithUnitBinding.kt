package ir.drax.binding2way.v

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.OnFocusChangeListener
import androidx.databinding.*


@InverseBindingMethods(InverseBindingMethod(type = EntryWithUnit::class, attribute = "text"))
open class EntryWithUnitBinding {
    companion object {

        @JvmStatic
        @BindingAdapter(value = ["textAttrChanged"])
        fun EntryWithUnit.setListener(textAttrChanged: InverseBindingListener?) {
            if (textAttrChanged != null) {
                /* binding.etValue.onFocusChangeListener =
                    OnFocusChangeListener { view: View?, focused: Boolean -> if (!focused) textAttrChanged.onChange() }
*/

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

        @JvmStatic
        @BindingAdapter("text")
        fun EntryWithUnit.setText(newValue: Any?) {
            if (newValue != null && newValue != value.value) setValue(newValue)
        }

        @JvmStatic
        @InverseBindingAdapter(attribute = "text")
        fun EntryWithUnit.getText(): Any {
            /*return if (tag.javaClass == Float::class.java && value.value != null) if (value.value!!
                    .isEmpty()
            ) 0f else if (value.value == "-") 0f else if (value.value == ".") 0f else try {
                value.value!!.toFloat()
            } catch (e: Exception) {
                e.printStackTrace()
                0f
            } else if (tag.javaClass == Int::class.java && value.value != null) if (value.value!!
                    .isEmpty()
            ) 0 else if (value.value == "-") 0 else if (value.value == ".") 0 else try {
                value.value!!.toInt()
            } catch (e: Exception) {
                e.printStackTrace()
                0
            } else value.value*/
            return 0
        }
    }
}
