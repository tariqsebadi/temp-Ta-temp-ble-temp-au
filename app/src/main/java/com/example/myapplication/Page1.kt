package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.adapter.MovieAdapter
import com.example.myapplication.databinding.FragmentPage1Binding
import com.example.myapplication.viewModels.Page1ViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [Page1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Page1 : Fragment() {

    private val viewModel: Page1ViewModel by lazy {
        ViewModelProvider(this).get(Page1ViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPage1Binding>(inflater, R.layout.fragment_page1, container, false)
        binding.button.setOnClickListener {
                sendSearchData(it)
        }

        binding.lifecycleOwner = this
        binding.viewModel = Page1ViewModel()
        binding.movieList.adapter = MovieAdapter()
        setHasOptionsMenu(true)

        return binding.root
    }

    fun sendSearchData(view: View){

    }

}