package ir.drax.binding2way

import androidx.databinding.DataBindingComponent
import ir.drax.binding2way.widget.InputWithUnitUtil

class BindingComp: DataBindingComponent {
     override fun getInputWithUnitUtil(): InputWithUnitUtil {
         return InputWithUnitUtil()
     }

}