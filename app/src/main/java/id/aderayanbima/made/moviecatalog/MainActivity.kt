package id.aderayanbima.made.moviecatalog

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import id.aderayanbima.made.moviecatalog.adapter.banner.BannerSliderAdapter
import id.aderayanbima.made.moviecatalog.adapter.banner.BannerSliderFragment
import id.aderayanbima.made.moviecatalog.adapter.tablayout.TabLayoutAdapter
import id.aderayanbima.made.moviecatalog.mvvm.movie.MovieFragment
import id.aderayanbima.made.moviecatalog.mvvm.tvshow.TvShowFragment
import id.aderayanbima.made.utils.Const
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var bannerAdapter: BannerSliderAdapter
    private lateinit var tabLayoutAdapter: TabLayoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPagerTab()
        setupBannerSlider()
        setupFloatingBar()

    }

    private fun setupBannerSlider() {
        bannerAdapter = BannerSliderAdapter(supportFragmentManager)
        bannerAdapter.apply {
            addBannerFragment(
                BannerSliderFragment(
                    Const.baseImageUrl + Const.spidermanPosterPath,
                    Const.spidermanTitle,
                    Const.spidermanOverview
                )
            )

            addBannerFragment(
                BannerSliderFragment(
                    Const.baseImageUrl + Const.toyStory4BackdropPath,
                    Const.toyStory4Title,
                    Const.toyStory4Overview
                )
            )

            addBannerFragment(
                BannerSliderFragment(
                    Const.baseImageUrl + Const.annabelleBackdropPath,
                    Const.annabelleTitle,
                    Const.annabelleOverview
                )
            )

            addBannerFragment(
                BannerSliderFragment(
                    Const.baseImageUrl + Const.darkPhoenixBackdropPath,
                    Const.darkPhoenixTitle,
                    Const.darkPhoenixOverview
                )
            )
            vp_banner.adapter = bannerAdapter
            tab_dot_banner.setupWithViewPager(vp_banner)
        }
    }

    private fun setupViewPagerTab() {
        tabLayoutAdapter = TabLayoutAdapter(this, supportFragmentManager)
        tabLayoutAdapter.apply {
            addFragment(MovieFragment(), getString(R.string.text_movie))
            addFragment(TvShowFragment(), getString(R.string.text_tv_show))
            vp_main.adapter = tabLayoutAdapter
            tab_main.setupWithViewPager(vp_main)
        }
    }

    private fun setupFloatingBar() {
        fab.apply {
            setOnClickListener {
                val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
                startActivity(mIntent)
            }
        }
    }
}
