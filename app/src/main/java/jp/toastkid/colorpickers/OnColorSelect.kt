package jp.toastkid.colorpickers

import android.support.annotation.ColorInt

/**
 * @author toastkidjp
 */
interface OnColorSelect {

    fun onSelect(@ColorInt color: Int)
}