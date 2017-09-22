package jp.toastkid.colorpickers.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.toastkid.colorpickers.R

/**
 * @author toastkidjp
 */
class RarepebbleFragment : BaseColorPickerFragment() {
    override fun onCreateView(
            inflater: LayoutInflater?,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_rarepebble, container, false)
    }

    override fun title(): String = "com.rarepebble.colorpicker"

}
