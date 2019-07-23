package id.aderayanbima.made.utils

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.aderayanbima.made.moviecatalog.R
import id.aderayanbima.made.moviecatalog.mvvm.movie.MovieAdapter
import id.aderayanbima.made.moviecatalog.mvvm.movie.MovieModel

object MainBindings {

    @BindingAdapter("app:listDataMovie")
    @JvmStatic
    fun setListDataMovie(recyclerView: RecyclerView, data: ObservableArrayList<MovieModel>) {
        with(recyclerView.adapter as MovieAdapter) {
            replaceData(data)
        }
    }

    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun setImageSource(imagView: ImageView, urlSource: String) {
        if (!TextUtils.isEmpty(urlSource)) {
            Glide.with(imagView.context)
                .load(urlSource)
                .error(R.color.colorAccent)
                .into(imagView)
        }
    }
}