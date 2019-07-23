package id.aderayanbima.made.moviecatalog.mvvm.movie;

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.AndroidViewModel
import id.aderayanbima.made.utils.Const
import com.google.gson.Gson
import id.aderayanbima.made.data.model.Response


class MovieViewModel(context: Application) : AndroidViewModel(context) {

    val MovieList: ObservableList<MovieModel> = ObservableArrayList()


    fun start() {
        loadData(Const.jsonNowPlayingMovies)
    }


    fun loadData(json: String) {

        val response = Gson().fromJson(json, Response::class.java)
        val data = response.results

        MovieList.clear()
        data.forEach {
            MovieList.add(MovieModel(Const.baseImageUrl + it.poster_path, it.title, it.overview, it.popularity.toString(), it.release_date))
        }

    }


}