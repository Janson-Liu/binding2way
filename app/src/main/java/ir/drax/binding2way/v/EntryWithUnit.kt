package ir.drax.binding2way.v

import android.content.Context
import android.content.res.TypedArray
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import androidx.lifecycle.MutableLiveData
import ir.drax.binding2way.R
import ir.drax.binding2way.databinding.EntryWithUnitBinding


class EntryWithUnit @JvmOverloads constructor(
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

    val binding = EntryWithUnitBinding.inflate(LayoutInflater.from(context),this,true)
    init {

        binding.model=this
        value.observeForever {
            it?.let { content->
                if(binding.etValue.text.toString()!=content){
                    binding.etValue.setText(content)
                }
            }
        }
        binding.etValue.onFocusChangeListener= OnFocusChangeListener { view, focused ->
            value.value?.let {
                if (focused && value.value!=null)
                    (view as EditText).setSelection(0)

            }
        }
        getAttributes(attrs)
    }

    private fun getAttributes(attrs: AttributeSet?) {
        val a: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.EntryWithUnit)
        for (i in 0 until a.indexCount) {
            when (val attr = a.getIndex(i)) {
                R.styleable.EntryWithUnit_readOnly -> readOnly.postValue(a.getBoolean(attr, readOnly.value!!))
                R.styleable.EntryWithUnit_hint -> hint = a.getString(attr).toString()
                R.styleable.EntryWithUnit_unit -> unit = a.getString(attr).toString()
//                R.styleable.EntryWithUnit_text -> value.postValue(a.getString(attr).toString())
                R.styleable.EntryWithUnit_maxLength -> maxLength = a.getInt(attr,maxLength)
                R.styleable.EntryWithUnit_inputType -> inputType = a.getInt(attr,inputType)
            }
        }
        a.recycle()
    }

    fun setValue(text:Any){
        tag=text
        value.postValue(text.toString())

    }
}