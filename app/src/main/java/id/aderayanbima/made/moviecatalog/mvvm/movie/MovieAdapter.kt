package id.aderayanbima.made.moviecatalog.mvvm.movie


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.aderayanbima.made.moviecatalog.databinding.ItemMovieBinding
import id.aderayanbima.made.moviecatalog.mvvm.detail.DetailMovieActivity


class MovieAdapter(val context: Context, data: List<MovieModel>, viewModel: MovieViewModel) :
    RecyclerView.Adapter<MovieAdapter.MovieItem>() {

    var mData = data
    val mViewModel = viewModel

    override fun onBindViewHolder(holder: MovieItem, position: Int) {
        holder.bind(context, mData[position], mViewModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItem {
        val binding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieItem(context, binding)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun replaceData(data: List<MovieModel>) {
        mData = data
        notifyDataSetChanged()
    }

    class MovieItem(context: Context, binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        val mBinding = binding;

        fun bind(context: Context, data: MovieModel, viewModel: MovieViewModel) {
            mBinding.mData = data
            mBinding.mListener = object : MovieUserActionListener {
                override fun onClickItem(data: MovieModel) {
                    DetailMovieActivity.startActivity(context, data)
                }
            }
        }
    }
}