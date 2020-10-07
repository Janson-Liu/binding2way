package ir.drax.binding2way

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    var testFloat= 8
    var testMutableInt= MutableLiveData(158)
    var testMutableString= MutableLiveData("Hey! I can be updated")
    fun update(v:View){

        Log.e("ss","$testFloat")
    }
}

