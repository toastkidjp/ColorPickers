package jp.toastkid.colorpickers.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.toastkid.colorpickers.R
import kotlinx.android.synthetic.main.fragment_holo_color_picker.*

/**
 * HoloColorPicker.
 *
 * @author toastkidjp
 */
class HoloColorPickerFragment : BaseColorPickerFragment() {

    override fun onCreateView(
            inflater: LayoutInflater?,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val rootView = inflater?.inflate(R.layout.fragment_holo_color_picker, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        color_picker?.addValueBar(value_bar)
        color_picker?.addOpacityBar(opacity_bar)
        color_picker?.addSVBar(sv_bar)
        color_picker?.setOnColorChangedListener { onColorSelect?.onSelect(it) }
    }

    override fun title(): String = "com.larswerkman.holocolorpicker"

}