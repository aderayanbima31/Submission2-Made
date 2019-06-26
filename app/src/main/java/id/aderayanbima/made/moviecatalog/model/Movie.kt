package id.aderayanbima.made.moviecatalog.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * @author Derayan Bima A (derayan.bima@dana.id)
 * @version Movie, v 0.1 2019-06-24 22:33 by Derayan Bima A
 */
@Parcelize
data class Movie(
    var photo: Int? = null,
    var name: String? = null,
    var description: String? = null,
    var rating: String? = null,
    var status: String? = null

) : Parcelable

