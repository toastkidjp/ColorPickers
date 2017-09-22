package jp.toastkid.colorpickers

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import jp.toastkid.colorpickers.fragments.FlaskFragment
import jp.toastkid.colorpickers.fragments.HoloColorPickerFragment
import jp.toastkid.colorpickers.fragments.JaredRummlerFragment
import jp.toastkid.colorpickers.fragments.RarepebbleFragment

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 *
 * @author toastkidjp
 */
internal class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> HoloColorPickerFragment()
        1 -> FlaskFragment()
        2 -> RarepebbleFragment()
        3 -> JaredRummlerFragment()
        else -> Fragment()
    }

    override fun getCount(): Int = 4

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> "SECTION 1"
        1 -> "SECTION 2"
        2 -> "SECTION 3"
        3 -> "SECTION 4"
        else -> ""
    }
}