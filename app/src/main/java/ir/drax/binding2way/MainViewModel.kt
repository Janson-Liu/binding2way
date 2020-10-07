package ir.drax.binding2way

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    var testFloat= 8f
    var testMutableInt= MutableLiveData<Int>()
    var testMutableString= MutableLiveData("Hey! I can be updated")
    fun update(v:View){

        Log.e("ss","$testFloat")
    }
}

