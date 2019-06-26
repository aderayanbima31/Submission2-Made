package id.aderayanbima.made.moviecatalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.aderayanbima.made.moviecatalog.adapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.content.res.TypedArray
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import id.aderayanbima.made.moviecatalog.model.Movie


class MainActivity : AppCompatActivity()  {

    lateinit var adapter : MovieAdapter

    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var movies: ArrayList<Movie>

    private lateinit var dataTitle: Array<String>


    private lateinit var dataRating: Array<String>

    private lateinit var dataStatus: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepare()

        adapter = MovieAdapter(this, addItem())
        lv_list.setAdapter(adapter)

        lv_list.setOnItemClickListener(object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {



                val listDataMovie = Movie(0,"","","","")
                listDataMovie.name = dataTitle[position]
                listDataMovie.photo = dataPhoto.getResourceId(position, position)
                listDataMovie.description = dataDescription[position]
                listDataMovie.status = dataStatus[position]
                listDataMovie.rating = dataRating[position]

                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, listDataMovie)

                this@MainActivity.startActivity(intent)
                Toast.makeText(this@MainActivity, movies.get(position).name, Toast.LENGTH_SHORT).show();
            }

        })

    }

    private fun addItem() : ArrayList<Movie> {

        movies = ArrayList()
        for (i in dataTitle.indices) {
            val movie = Movie()
            movie.photo = dataPhoto.getResourceId(i, -1)
            movie.name = dataTitle.get(i)
            movie.description = dataDescription.get(i)
            movies.add(movie)
        }
        return movies
    }

    private fun prepare() {

        dataTitle = resources.getStringArray(R.array.data_title_movie)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_image_movie)
        dataRating = resources.getStringArray(R.array.data_rating)
        dataStatus = resources.getStringArray(R.array.status)

    }
}
