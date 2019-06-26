package id.aderayanbima.made.moviecatalog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.aderayanbima.made.moviecatalog.model.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val listMovie : Movie = intent.getParcelableExtra(EXTRA_DATA)

        tv_judul.text = listMovie.name
        tv_status.text = listMovie.status
        tv_rating.text = listMovie.rating
        tv_detail.text = listMovie.description
        iv_poster.setImageResource(listMovie.photo!!)
    }

    companion object{
        var EXTRA_DATA = "0"
    }
}
