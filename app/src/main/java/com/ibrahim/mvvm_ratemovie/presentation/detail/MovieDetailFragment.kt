package com.ibrahim.mvvm_ratemovie.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.ibrahim.mvvm_ratemovie.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment:Fragment() {
    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    private val args: MovieDetailFragmentArgs by navArgs ()
    private val viewModel: MovieDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initArgs()
        observeMovie()
        initClickListeners()
    }

    private fun initArgs(){
        viewModel.movie.value = args.movie
    }
    private fun observeMovie() {
        viewModel.movie.observe(viewLifecycleOwner){movie->


            Glide.with(binding.movieDetailPoster.context)
                .load("https://image.tmdb.org/t/p/w500"+movie?.posterPath)
                .into(binding.movieDetailPoster)

            binding.movieDetailTitle.text = movie?.title
            binding.movieDetailCategory.text = movie?.genreIds.toString()
            binding.movieDetailAverage.text = movie?.voteAverage.toString()
            binding.movieDetailDate.text = movie?.releaseDate
            binding.movieDetailDescription.text = movie?.overview
        }

    }

    private fun initClickListeners() {
        binding.movieDetailBtnSeven.setOnClickListener {
            viewModel.insertUserRating(7)
            val action=MovieDetailFragmentDirections.actionMovieDetailFragmentToHomeFragment()
            Navigation.findNavController(it).navigate(action)
            Toast.makeText(context,"The movie was added seventh list.",Toast.LENGTH_SHORT).show()
        }

        binding.movieDetailBtnEight.setOnClickListener {
            viewModel.insertUserRating(8)
            val action=MovieDetailFragmentDirections.actionMovieDetailFragmentToHomeFragment()
            Navigation.findNavController(it).navigate(action)
            Toast.makeText(context,"The movie was added eighth list.",Toast.LENGTH_SHORT).show()
        }

        binding.movieDetailBtnNine.setOnClickListener {
            viewModel.insertUserRating(9)
            val action=MovieDetailFragmentDirections.actionMovieDetailFragmentToHomeFragment()
            Navigation.findNavController(it).navigate(action)
            Toast.makeText(context,"The movie was added ninth list.",Toast.LENGTH_SHORT).show()

        }

        binding.movieDetailBtnTen.setOnClickListener {
            viewModel.insertUserRating(10)
            val action=MovieDetailFragmentDirections.actionMovieDetailFragmentToHomeFragment()
            Navigation.findNavController(it).navigate(action)
            Toast.makeText(context,"The movie was added tenth list.",Toast.LENGTH_SHORT).show()

        }
    }

    //Fragment Destroy edildiğinde binding boşaltılsın diye
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}