package ir.drax.binding2way

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    var testFloat=13

    fun update(v:View){
        Log.e("ss","$testFloat")
    }
}