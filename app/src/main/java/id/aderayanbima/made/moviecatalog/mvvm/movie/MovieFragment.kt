package id.aderayanbima.made.moviecatalog.mvvm.movie


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import id.aderayanbima.made.moviecatalog.databinding.FragmentMovieBinding


class MovieFragment : Fragment() {

    lateinit var mViewDataBinding: FragmentMovieBinding
    lateinit var mViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mViewDataBinding = FragmentMovieBinding.inflate(inflater!!, container!!, false)
        mViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        mViewDataBinding.mViewModel = mViewModel.apply {

        }

        mViewDataBinding.mListener = object : MovieUserActionListener {
            override fun onClickItem(data: MovieModel) {
                //No Implementation
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
        mViewDataBinding.recyclerMovie.apply {
            adapter = MovieAdapter(context, mViewModel.MovieList, mViewModel)
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
        }

    }


    companion object {
        fun newInstance() = MovieFragment().apply {

        }

    }

}
