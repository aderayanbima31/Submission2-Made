package id.aderayanbima.made.moviecatalog.mvvm.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MovieModel(
    var image: String? = null,
    var title: String? = null,
    var description: String? = null,
    var rating: String? = null,
    var release: String? = null

) : Parcelable
