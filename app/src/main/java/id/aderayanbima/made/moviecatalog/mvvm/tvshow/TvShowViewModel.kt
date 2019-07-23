package id.aderayanbima.made.moviecatalog.mvvm.tvshow;

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.AndroidViewModel
import id.aderayanbima.made.utils.Const
import com.google.gson.Gson
import id.aderayanbima.made.data.model.Response


class TvShowViewModel(context: Application) : AndroidViewModel(context) {

    val TvShowList: ObservableList<TvShowModel> = ObservableArrayList()


    fun start() {
        loadData(Const.jsonTopRatedTv)
    }


    fun loadData(json: String) {

        val response = Gson().fromJson(json, Response::class.java)
        val data = response.results

        TvShowList.clear()
        data.forEach {
            TvShowList.add(TvShowModel(Const.baseImageUrl + it.poster_path, it.original_name, it.overview, it.popularity.toString(), it.first_air_date))
        }

    }



}