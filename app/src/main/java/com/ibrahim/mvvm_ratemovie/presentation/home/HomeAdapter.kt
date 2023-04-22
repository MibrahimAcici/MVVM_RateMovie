package com.ibrahim.mvvm_ratemovie.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahim.mvvm_ratemovie.databinding.ItemMovieBinding
import com.ibrahim.mvvm_ratemovie.domain.model.Movie

class HomeAdapter(private val itemCallback: (Movie?) ->Unit) : RecyclerView.Adapter<HomeAdapter.MovieVH>() {

    private var movieList: ArrayList<Movie?> = arrayListOf()

    fun setList(newList: List<Movie?>) {
        this.movieList.clear()
        this.movieList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class MovieVH(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        return MovieVH(ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        val movie=movieList[position]
        //https://image.tmdb.org/t/p/w500/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg

        Glide.with(holder.binding.imageMovie.context)
            .load("https://image.tmdb.org/t/p/w500"+movie?.posterPath)
            .into(holder.binding.imageMovie)
        holder.binding.tvMovieName.text=movie?.title
        holder.binding.tvMovieCategory.text=movie?.genreIds.toString()
        holder.binding.tvMovieAverage.text=movie?.voteAverage.toString()
        holder.binding.tvMovieDate.text=movie?.releaseDate


        holder.binding.root.setOnClickListener {
           itemCallback.invoke(movie)
        }

    }

    override fun getItemCount(): Int = movieList.size

}