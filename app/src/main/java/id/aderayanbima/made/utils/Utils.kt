package id.aderayanbima.made.utils

import android.content.Context
import android.text.TextUtils
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import java.util.*

object Utils{
    fun nomalizeRating(oldValue: Float): Float{
        return ((oldValue-0)/10-0)*((5-0)+0)
    }

    fun setLocale(lang: String, context: Context) {
        val res = context.resources
        val dm = res.displayMetrics
        val conf = res.configuration
        conf.setLocale(Locale(lang.toLowerCase()))
        res.updateConfiguration(conf, dm)
    }

    fun createCircularProgressDrawable(context: Context): CircularProgressDrawable{
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 4f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        return circularProgressDrawable
    }

    fun setImageSource(imageView: ImageView, urlSource: String) {
        if (!TextUtils.isEmpty(urlSource)) {
            Glide.with(imageView.context)
                .load(urlSource)
                .into(imageView)
        }
    }
}