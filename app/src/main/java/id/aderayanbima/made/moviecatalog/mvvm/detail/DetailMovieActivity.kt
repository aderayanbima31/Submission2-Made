package id.aderayanbima.made.moviecatalog.mvvm.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import id.aderayanbima.made.utils.Const
import com.bumptech.glide.Glide
import id.aderayanbima.made.moviecatalog.R
import id.aderayanbima.made.moviecatalog.mvvm.movie.MovieModel
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val listMovie : MovieModel = intent.getParcelableExtra(Const.EXTRA_DETAIL)

        tv_judul.text = listMovie.title
        tv_status.text = listMovie.release
        tv_rating.text = listMovie.rating
        tv_detail.text = listMovie.description
        Glide.with(this)
            .load(listMovie.image)
            .into(iv_poster)

        iv_back_movie.setOnClickListener {
            onBackPressed()
        }
    }

    companion object {

        fun startActivity(context: Context, data: MovieModel) {
            val intent = Intent(context, DetailMovieActivity::class.java)
            intent.putExtra(Const.EXTRA_DETAIL, data)
            context.startActivity(intent)
        }
    }
}
