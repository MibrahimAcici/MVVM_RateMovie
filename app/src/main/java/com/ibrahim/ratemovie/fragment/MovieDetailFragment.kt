package com.ibrahim.ratemovie.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.ibrahim.ratemovie.databinding.FragmentMovieDetailBinding
import com.ibrahim.ratemovie.db.AppDatabase
import com.ibrahim.ratemovie.db.Database
import com.ibrahim.ratemovie.db.entity.MovieEntity
import com.ibrahim.ratemovie.viewmodel.MovieDetailViewModel

class MovieDetailFragment:Fragment() {
    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    private val args:MovieDetailFragmentArgs by navArgs ()
    private val viewModel: MovieDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.movieDetailBtnSeven.setOnClickListener {

                val movie = MovieEntity(movieId = viewModel.movie.value?.id?:0, userVote = 7, posterPath = viewModel.movie.value?.posterPath.toString(), title = viewModel.movie.value?.title.toString(), genreIds = viewModel.movie.value?.genreIds.toString(), voteAverage = viewModel.movie.value?.voteAverage.toString(), releaseDate = viewModel.movie.value?.releaseDate.toString())
                Database.getDatabase(applicationContext =requireContext()).moviedao().insertMovie(movie)

            }

        binding.movieDetailBtnEight.setOnClickListener {

            val movie = MovieEntity(movieId = viewModel.movie.value?.id?:0, userVote = 8, posterPath = viewModel.movie.value?.posterPath.toString(), title = viewModel.movie.value?.title.toString(), genreIds = viewModel.movie.value?.genreIds.toString(), voteAverage = viewModel.movie.value?.voteAverage.toString(), releaseDate = viewModel.movie.value?.releaseDate.toString())
            Database.getDatabase(applicationContext =requireContext()).moviedao().insertMovie(movie)

        }

        binding.movieDetailBtnNine.setOnClickListener {

            val movie = MovieEntity(movieId = viewModel.movie.value?.id?:0, userVote = 9, posterPath = viewModel.movie.value?.posterPath.toString(), title = viewModel.movie.value?.title.toString(), genreIds = viewModel.movie.value?.genreIds.toString(), voteAverage = viewModel.movie.value?.voteAverage.toString(), releaseDate = viewModel.movie.value?.releaseDate.toString())
            Database.getDatabase(applicationContext =requireContext()).moviedao().insertMovie(movie)

        }

        binding.movieDetailBtnTen.setOnClickListener {

            val movie = MovieEntity(movieId = viewModel.movie.value?.id?:0, userVote = 10, posterPath = viewModel.movie.value?.posterPath.toString(), title = viewModel.movie.value?.title.toString(), genreIds = viewModel.movie.value?.genreIds.toString(), voteAverage = viewModel.movie.value?.voteAverage.toString(), releaseDate = viewModel.movie.value?.releaseDate.toString())
            Database.getDatabase(applicationContext =requireContext()).moviedao().insertMovie(movie)

        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initArgs()
        observeMovie()
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

    //Fragment Destroy edildiğinde binding boşaltılsın diye
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}