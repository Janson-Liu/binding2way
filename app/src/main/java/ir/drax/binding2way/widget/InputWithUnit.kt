package ir.drax.binding2way.widget

import android.content.Context
import android.content.res.TypedArray
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import androidx.lifecycle.MutableLiveData
import ir.drax.binding2way.R
import ir.drax.binding2way.databinding.InputWithUnitBinding


class InputWithUnit @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {


    var readOnly=MutableLiveData<Boolean>(false)
    var value=MutableLiveData<String>("")

    var unit=""
    var hint=""
    var maxLength=5

    var inputType= InputType.TYPE_CLASS_TEXT
        set(value) {
            field=value
            binding.etValue.inputType=value
        }

    val binding = InputWithUnitBinding.inflate(LayoutInflater.from(context),this,true)
    init {

        binding.model=this
        value.observeForever {
            if (binding.etValue.isFocused.not())
                it?.let { content->
                    if(binding.etValue.text.toString()!=content){
                        binding.etValue.setText(
                            if (tag is Float || tag is Double)
                                String.format("%.1f",tag)

                            else
                                content

                        )
                    }
                }
        }

        getAttributes(attrs)
    }

    private fun getAttributes(attrs: AttributeSet?) {
        val a: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.InputWithUnit)
        for (i in 0 until a.indexCount) {
            when (val attr = a.getIndex(i)) {
                R.styleable.InputWithUnit_readOnly -> readOnly.postValue(a.getBoolean(attr, readOnly.value!!))
                R.styleable.InputWithUnit_hint -> hint = a.getString(attr).toString()
                R.styleable.InputWithUnit_unit -> unit = a.getString(attr).toString()
//                R.styleable.InputWithUnit_text -> value.postValue(a.getString(attr).toString())
                R.styleable.InputWithUnit_maxLength -> maxLength = a.getInt(attr,maxLength)
                R.styleable.InputWithUnit_inputType -> inputType = a.getInt(attr,inputType)
            }
        }
        a.recycle()
    }

    fun setValue(text:Any){

        tag=text // Let's Keep the original value in tag
        value.postValue(text.toString())

    }
}