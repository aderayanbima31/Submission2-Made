package id.aderayanbima.made.moviecatalog.mvvm.tvshow


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import id.aderayanbima.made.moviecatalog.databinding.FragmentTvShowBinding
import id.aderayanbima.made.moviecatalog.mvvm.movie.MovieModel
import id.aderayanbima.made.moviecatalog.mvvm.tvshow.TvShowAdapter


class TvShowFragment : Fragment() {

    lateinit var mViewDataBinding: FragmentTvShowBinding
    lateinit var mViewModel: TvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mViewDataBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        mViewModel = ViewModelProviders.of(this).get(TvShowViewModel::class.java)

        mViewDataBinding.mViewModel = mViewModel.apply {

        }

        mViewDataBinding.mListener = object : TvShowUserActionListener {
            override fun onClickItem(data: TvShowModel) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
        return mViewDataBinding.root

    }

    override fun onResume() {
        super.onResume()
        mViewDataBinding.mViewModel?.start()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupListData()
    }



    fun setupListData() {
        mViewDataBinding.recyclerTvShow.apply {
            adapter = TvShowAdapter(context, mViewModel.TvShowList, mViewModel)
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
        }

    }


    companion object {
        fun newInstance() = TvShowFragment().apply {

        }

    }

}
