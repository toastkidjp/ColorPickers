package jp.toastkid.colorpickers.fragments

import android.os.Bundle
import android.support.v4.graphics.ColorUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.toastkid.colorpickers.R
import kotlinx.android.synthetic.main.fragment_hsv_alpha.*

/**
 * <a href="https://github.com/martin-stone/hsv-alpha-color-picker-android">
 *     martin-stone/hsv-alpha-color-picker-android</a>'s sample implementation.
 *
 * @author toastkidjp
 */
class HsvAlphaFragment : BaseColorPickerFragment() {
    override fun onCreateView(
            inflater: LayoutInflater?,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_hsv_alpha, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        color_picker.addColorObserver { color -> onColorSelect?.onSelect(
                ColorUtils.setAlphaComponent(color.color, color.alpha)
        ) }
    }

    override fun title(): String = "hsv-alpha-colorpicker"

}
