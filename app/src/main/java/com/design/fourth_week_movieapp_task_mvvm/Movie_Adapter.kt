package com.design.fourth_week_movieapp_task_mvvm

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class Movie_Adapter(private val context: Context, private val moviesList: List<Movie>) :
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
        val movie = moviesList[position]
        val I = Intent(context, Movie_Info::class.java)
        holder.poster.setOnClickListener{
            I.putExtra("Poster Path", movie.poster_path)
            I.putExtra("Release Date", movie.release_date)
            I.putExtra("Title", movie.title)
            I.putExtra("Overview", movie.overview)
            I.putExtra("Original Language", movie.original_language)
            I.putExtra("Popularity", movie.popularity)
            I.putExtra("Vote Average", movie.vote_average)
            context.startActivity(I)
        }

    }

    override fun getItemCount(): Int
    {
        return moviesList.size
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
         val poster = itemView.Poster


        fun Bind_Movie_Data(movie: Movie)
        {
            Picasso.get().load("https://image.tmdb.org/t/p/w500/${movie.poster_path}").into(poster)
        }
    }

}