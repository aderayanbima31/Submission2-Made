package id.aderayanbima.made.moviecatalog.adapter.banner

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


/**
 * @author Derayan Bima A (derayan.bima@dana.id)
 * @version BannerSliderAdapter, v 0.1 2019-07-22 17:24 by Derayan Bima A
 */
class BannerSliderAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val listBannerFragment = ArrayList<Fragment>()

    override fun getItem(position: Int) : Fragment = listBannerFragment[position]

    override fun getCount(): Int = listBannerFragment.size

    fun addBannerFragment(fragment: Fragment){
        listBannerFragment.add(fragment)
    }

}