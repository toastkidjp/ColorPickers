package jp.toastkid.colorpickers

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import jp.toastkid.colorpickers.fragments.*

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 *
 * @author toastkidjp
 */
internal class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments: List<BaseColorPickerFragment> = listOf(
            HoloColorPickerFragment(),
            FlaskFragment(),
            HsvAlphaFragment(),
            JaredRummlerFragment(),
            PikoloFragment(),
            KristiyanpFragment()
    )

    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): Fragment = fragments.get(position)

    override fun getPageTitle(position: Int): String = fragments.get(position).title()
}