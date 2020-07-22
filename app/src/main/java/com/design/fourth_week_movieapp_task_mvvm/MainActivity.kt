package com.design.fourth_week_movieapp_task_mvvm

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mainViewModel: Main_View_Model by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.get_Popular_Movies().observe(this, Observer {
            Recycler_View.adapter = Movie_Adapter(this, it)
        } )

        Popular_Movies.setOnClickListener{mainViewModel.get_Popular_Movies().observe(this, Observer {
            Recycler_View.adapter = Movie_Adapter(this, it)} )}

        Top_Rated_Movies.setOnClickListener{mainViewModel.get_Top_Movies().observe(this, Observer {
            Recycler_View.adapter = Movie_Adapter(this, it)} )}


    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

}