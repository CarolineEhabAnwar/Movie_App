package com.design.fourth_week_movieapp_task_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_info.*

class Movie_Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_info)

        Title?.text = intent.getStringExtra("Title")
        Picasso.get().load("https://image.tmdb.org/t/p/w500/${intent.getStringExtra("Poster Path")}").into(Poster)
        Overview?.text = intent.getStringExtra("Overview")
        Release_Date?.text = intent.getStringExtra("Release Date")
        Original_Langauge?.text = intent.getStringExtra("Original Language")
        Popularity?.text = intent.getFloatExtra("Popularity", 0F).toString()
        Vote_Average?.text = intent.getFloatExtra("Vote Average", 0F).toString()

    }
}
