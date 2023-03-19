package com.ibrahim.mvvm_ratemovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahim.mvvm_ratemovie.databinding.ItemMovieBinding
import com.ibrahim.mvvm_ratemovie.db.entity.MovieEntity

class RateMovieAdapter  : RecyclerView.Adapter<RateMovieAdapter.RateMovieVH>() {

    private val ratemovies: ArrayList<MovieEntity> = arrayListOf()

    fun setList(ratemovies:List<MovieEntity>){
        this.ratemovies.clear()
        this.ratemovies.addAll(ratemovies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType : Int): RateMovieVH {
        return RateMovieVH(ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int=ratemovies.size

    override fun onBindViewHolder(holder: RateMovieVH, position: Int) {
        val movie=ratemovies[position]

        Glide.with(holder.binding.imageMovie.context)
            .load("https://image.tmdb.org/t/p/w500"+movie.posterPath)
            .into(holder.binding.imageMovie)
        holder.binding.tvMovieName.text=movie.title
        holder.binding.tvMovieCategory.text=movie.genreIds.toString()
        holder.binding.tvMovieAverage.text=movie.voteAverage.toString()
        holder.binding.tvMovieDate.text=movie.releaseDate
    }

    inner class RateMovieVH(val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
    }
}