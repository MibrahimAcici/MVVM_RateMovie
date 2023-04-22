package com.ibrahim.mvvm_ratemovie.presentation.eight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahim.mvvm_ratemovie.presentation.rate.RateMovieAdapter
import com.ibrahim.mvvm_ratemovie.databinding.FragmentEightBinding
import com.ibrahim.mvvm_ratemovie.presentation.rate.RateMovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EightFragment:Fragment() {
    private var _binding: FragmentEightBinding? = null
    private val binding get() = _binding!!

    private lateinit var rateMovieAdapter: RateMovieAdapter
    private val viewModel: RateMovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEightBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        observeRatedList()
    }

    private fun observeRatedList() {
        viewModel.ratedMovie(8).observe(viewLifecycleOwner) {
            rateMovieAdapter.setList(it)
        }
    }

    private fun initAdapter() {
        rateMovieAdapter = RateMovieAdapter()
        binding.recyclerView.adapter = rateMovieAdapter
        //Adapterin Ekrandaki Görünümü
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
    }

    //Fragment Destroy edildiğinde binding boşaltılsın diye
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}