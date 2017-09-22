package jp.toastkid.colorpickers.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.toastkid.colorpickers.R
import kotlinx.android.synthetic.main.fragment_quad_flask.*

/**
 * @author toastkidjp
 */
class FlaskFragment : BaseColorPickerFragment() {

    override fun onCreateView(
            inflater: LayoutInflater?,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val rootView = inflater?.inflate(R.layout.fragment_quad_flask, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        color_picker.addOnColorSelectedListener { onColorSelect?.onSelect(it) }
    }

    override fun title(): String = "com.flask.colorpicker"
}
