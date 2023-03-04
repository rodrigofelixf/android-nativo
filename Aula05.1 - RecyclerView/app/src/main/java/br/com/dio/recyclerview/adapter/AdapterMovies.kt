package br.com.dio.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.recyclerview.databinding.MovieItemBinding
import br.com.dio.recyclerview.mock.DataSource
import br.com.dio.recyclerview.model.MovieModel

class AdapterMovies(
    private val context: Context,
    private val moviesList: MutableList<MovieModel>
    ): RecyclerView.Adapter<AdapterMovies.MovieViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemList = MovieItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return MovieViewHolder(itemList)

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.txtMovieTitle.text = moviesList[position].title
        holder.txtMovieYear.text = moviesList[position].year

    }

    override fun getItemCount(): Int {
        return moviesList.size

    }

    inner class MovieViewHolder(binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
        val txtMovieTitle = binding.movieTitle
        val txtMovieYear = binding.movieYear

    }
}