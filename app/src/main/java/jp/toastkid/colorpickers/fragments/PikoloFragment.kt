package jp.toastkid.colorpickers.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener
import jp.toastkid.colorpickers.R
import kotlinx.android.synthetic.main.fragment_pikolo.*

/**
 * <a href="https://github.com/Madrapps/Pikolo">Madrapps/Pikolo</a>
 *
 * @author toastkidjp
 */
class PikoloFragment : BaseColorPickerFragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_pikolo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        color_picker.setColorSelectionListener(object : SimpleColorSelectionListener() {
            override fun onColorSelected(color: Int)
                    = onColorSelect?.onSelect(color) as Unit
        })
    }

    override fun title(): String = "Madrapps/Pikolo"
}
