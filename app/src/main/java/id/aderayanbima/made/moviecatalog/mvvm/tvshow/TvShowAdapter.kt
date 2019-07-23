package id.aderayanbima.made.moviecatalog.mvvm.tvshow


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.aderayanbima.made.moviecatalog.databinding.ItemTvShowBinding
import id.aderayanbima.made.moviecatalog.mvvm.detail.DetailTvActivity


class TvShowAdapter(val context: Context, data: List<TvShowModel>, viewModel: TvShowViewModel) :
    RecyclerView.Adapter<TvShowAdapter.TvShowItem>() {

    override fun onBindViewHolder(holder: TvShowItem, position: Int) {
        holder.bind(context, mData[position], mViewModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowItem {
        val binding = ItemTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowItem(context, binding)
    }

    var mData = data
    val mViewModel = viewModel

    override fun getItemCount(): Int {
        return mData.size
    }


    fun replaceData(data: List<TvShowModel>) {
        mData = data
        notifyDataSetChanged()
    }


    class TvShowItem(context: Context, binding: ItemTvShowBinding) : RecyclerView.ViewHolder(binding.root) {
        val mBinding = binding;

        fun bind(context: Context, data: TvShowModel, viewModel: TvShowViewModel) {
            mBinding.mData = data
            mBinding.mListener = object : TvShowUserActionListener {
                override fun onClickItem(data: TvShowModel) {
                    DetailTvActivity.startActivity(context, data)
                }

            }
        }

    }

}