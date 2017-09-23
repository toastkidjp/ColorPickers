package jp.toastkid.colorpickers.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.toastkid.colorpickers.R
import kotlinx.android.synthetic.main.fragment_kristiyanp.*
import petrov.kristiyan.colorpicker.ColorPicker

/**
 * <a href="https://github.com/kristiyanP/colorpicker">kristiyanP/colorpicker</a>'s
 * sample implementation.
 *
 * @author toastkidjp
 */
class KristiyanpFragment : BaseColorPickerFragment() {

    override fun onCreateView(
            inflater: LayoutInflater?,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_kristiyanp, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener{ _ -> showColorPicker() }
    }

    private fun showColorPicker() {
        ColorPicker(activity).setColors(
                Color.parseColor("#82B926"),
                Color.parseColor("#a276eb"),
                Color.parseColor("#6a3ab2"),
                Color.parseColor("#666666"),
                Color.parseColor("#FFFF00"),
                Color.parseColor("#3C8D2F"),
                Color.parseColor("#FA9F00"),
                Color.parseColor("#FF0000")
                )
                .setDefaultColorButton(Color.parseColor("#f84c44"))
                .setColumns(5)
                .setOnChooseColorListener(object : ColorPicker.OnChooseColorListener {
                    override fun onChooseColor(position: Int, color: Int)
                            = onColorSelect?.onSelect(color) as Unit

                    override fun onCancel() = Unit
                })
                .setRoundColorButton(true).show()
    }

    override fun title(): String = "Madrapps/Pikolo"
}