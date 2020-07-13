package com.design.third_week_movieapp_task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class Movie_Adapter(private val moviesList: List<Movie>) :
    RecyclerView.Adapter<Movie_Adapter.MovieViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        val movieViewLayout = layoutInflater.inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(movieViewLayout)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int)
    {
        holder.Bind_Movie_Data(moviesList[position])
    }

    override fun getItemCount(): Int
    {
        return moviesList.size
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private val poster = itemView.Poster
        fun Bind_Movie_Data(movie: Movie)
        {
            Picasso.get().load("https://image.tmdb.org/t/p/w500/${movie.poster_path}").into(poster)
        }
    }

}