package id.aderayanbima.made.moviecatalog.mvvm.tvshow

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class TvShowModel(
    var image: String? = null,
    var title: String? = null,
    var description: String? = null,
    var rating: String? = null,
    var release: String? = null

) : Parcelable
