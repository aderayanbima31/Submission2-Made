package id.aderayanbima.made.moviecatalog.adapter

import android.content.Context
import android.content.Intent
import android.content.res.TypedArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import id.aderayanbima.made.moviecatalog.R
import id.aderayanbima.made.moviecatalog.model.Movie
import android.widget.TextView
import android.widget.Toast
import id.aderayanbima.made.moviecatalog.MainActivity
import android.widget.AdapterView
import id.aderayanbima.made.moviecatalog.DetailActivity


/**
 * @author Derayan Bima A (derayan.bima@dana.id)
 * @version MovieAdapter, v 0.1 2019-06-24 22:26 by Derayan Bima A
 */
class MovieAdapter(val context: Context, private val listMovie : ArrayList<Movie>) : BaseAdapter() {

    //private var movies: ArrayList<Movie>? = null

    private lateinit var listPict : TypedArray
    private lateinit var listTitle : Array<String>
    private lateinit var listDetail : Array<String>
    private lateinit var listStatus : Array<String>
    private lateinit var listBudget : Array<String>

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View? {


        var view = view
        if(view == null) {
            //holder = ViewHolder()
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.item_movie, null, true)
        }

        val viewHolder = view?.let { ViewHolder(it) }
        val movie = getItem(position) as Movie
        viewHolder?.bind(movie)

        return view
    }

    private inner class ViewHolder internal constructor(view: View) {

        private val txtName: TextView
        private val txtDescription: TextView
        private val imgPhoto: ImageView

        init {
            txtName = view.findViewById(R.id.txt_name)
            txtDescription = view.findViewById(R.id.txt_description)
            imgPhoto = view.findViewById(R.id.img_photo)
        }

        internal fun bind(movie: Movie) {
            txtName.setText(movie.name)
            txtDescription.setText(movie.description)
            imgPhoto.setImageResource(movie.photo ?: 0)
        }
    }


    override fun getItem(i: Int): Any {
        return listMovie.get(i) ?: 0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return listMovie.size ?: 0
    }





}