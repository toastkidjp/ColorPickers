package jp.toastkid.colorpickers.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.toastkid.colorpickers.R
import kotlinx.android.synthetic.main.fragment_quad_flask.*

/**
 * <a href="https://github.com/QuadFlask/colorpicker">QuadFlask/colorpicker</a>
 *
 * @author toastkidjp
 */
class FlaskFragment : BaseColorPickerFragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_quad_flask, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        color_picker.addOnColorSelectedListener { onColorSelect?.onSelect(it) }
    }

    override fun title(): String = "com.flask.colorpicker"
}
