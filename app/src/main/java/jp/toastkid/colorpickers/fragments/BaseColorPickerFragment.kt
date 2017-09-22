package jp.toastkid.colorpickers.fragments

import android.content.Context
import android.support.v4.app.Fragment
import jp.toastkid.colorpickers.OnColorSelect

/**
 * @author toastkidjp
 */
abstract class BaseColorPickerFragment: Fragment() {

    var onColorSelect: OnColorSelect? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        onColorSelect = context as OnColorSelect
    }

    abstract fun title(): String
}