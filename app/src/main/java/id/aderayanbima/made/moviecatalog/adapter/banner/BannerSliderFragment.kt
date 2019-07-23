package id.aderayanbima.made.moviecatalog.adapter.banner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import id.aderayanbima.made.moviecatalog.R
import kotlinx.android.synthetic.main.fragment_banner_slider.*
import kotlinx.android.synthetic.main.fragment_banner_slider.view.*


/**
 * @author Derayan Bima A (derayan.bima@dana.id)
 * @version BannerSliderFragment, v 0.1 2019-07-22 16:59 by Derayan Bima A
 */
class BannerSliderFragment (private val imageUrl: String, private val title: String, private val overview: String) :
    Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_banner_slider, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireContext())
            .load(imageUrl)
            .error(R.drawable.ic_error_image)
            .into(view.iv_banner)
        tv_overview.text = overview
        tv_title.text= title

    }

}