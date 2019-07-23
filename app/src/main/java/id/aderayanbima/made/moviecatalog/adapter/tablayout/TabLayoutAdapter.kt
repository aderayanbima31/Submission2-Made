package id.aderayanbima.made.moviecatalog.adapter.tablayout

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import id.aderayanbima.made.moviecatalog.R


/**
 * @author Derayan Bima A (derayan.bima@dana.id)
 * @version TabLayoutAdapter, v 0.1 2019-07-15 21:29 by Derayan Bima A
 */
class TabLayoutAdapter(val context: Context, fragmentManager: FragmentManager?) : FragmentStatePagerAdapter(fragmentManager) {

    val listDotActive = ArrayList<Drawable>()
    val listDotInactive = ArrayList<Drawable>()

    val fragmentList = arrayListOf<Fragment>()
    val titleList = arrayListOf<String>()

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        titleList.add(title)
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]


    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> context.getString(R.string.text_movie)
            else -> context.getString(R.string.text_tv_show)
        }


    }

}