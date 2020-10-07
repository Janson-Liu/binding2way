package ir.drax.binding2way

import android.app.Application
import androidx.databinding.DataBindingUtil

class app:Application() {

    override fun onCreate() {
        super.onCreate()

        DataBindingUtil.setDefaultComponent(BindingComp())
    }
}