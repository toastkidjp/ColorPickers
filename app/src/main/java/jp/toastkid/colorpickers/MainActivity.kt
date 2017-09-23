package jp.toastkid.colorpickers

import android.content.Intent
import android.net.Uri
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

    /**
     * Contents pager's adapter.
     */
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

        initViewPager()
    }

    /**
     * Initialize view pager.
     */
    private fun initViewPager() {
        mViewPager = findViewById<View>(R.id.container) as ViewPager
        mViewPager?.adapter = mSectionsPagerAdapter
        mViewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) = Unit

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int)
                = Unit//onNewPage(position)

            override fun onPageSelected(position: Int) = onNewPage(position)

            private fun onNewPage(position: Int) {
                if (position == 0) {
                    left.visibility = View.GONE
                } else {
                    left.visibility = View.VISIBLE
                }
                if (position == ((mSectionsPagerAdapter?.count ?: 1) - 1)) {
                    right.visibility = View.GONE
                } else {
                    right.visibility = View.VISIBLE
                }
            }
        })
        left.setOnClickListener  { mViewPager?.currentItem = (mViewPager?.currentItem ?: 0) - 1 }
        right.setOnClickListener { mViewPager?.currentItem = (mViewPager?.currentItem ?: 0) + 1 }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
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
            R.id.action_author -> {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("market://search?q=pub:toastkidjp")
                startActivity(intent)
                return true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onSelect(color: Int) {
        toolbar.setBackgroundColor(color)
    }

}
