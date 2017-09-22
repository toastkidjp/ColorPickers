package jp.toastkid.colorpickers

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import jp.toastkid.colorpickers.libs.LicenseViewer
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Main activity of this app.
 *
 * @author toastkidjp
 */
class MainActivity : AppCompatActivity(), OnColorSelect {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    /**
     * The [ViewPager] that will host the section contents.
     */
    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        mViewPager = findViewById<View>(R.id.container) as ViewPager
        mViewPager?.adapter = mSectionsPagerAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_exit -> {
                finish()
                return true
            }
            R.id.action_licenses -> {
                LicenseViewer(this).invoke()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSelect(color: Int) {
        toolbar.setBackgroundColor(color)
    }

}
