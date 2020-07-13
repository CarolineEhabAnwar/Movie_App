package com.design.third_week_movieapp_task

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity()
{
    private val tag: String = MainActivity::class.java.simpleName
    private lateinit var APIService: API_Service

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        APIService = Retrofit_Client.Get_Retrofit_Client().create(API_Service::class.java)
        APIService.Get_Popular_Movies("0a01d24f102b98e78312e878be0e1e65").enqueue(object : Callback<Movie_Response>
        {

            override fun onResponse(call: Call<Movie_Response>, response: Response<Movie_Response>)
            {
                if(response.isSuccessful)
                {
                    val movieList : List<Movie> = response.body()?.results?: listOf()
                    Recycler_View.adapter = Movie_Adapter(movieList)


                }
            }

            override fun onFailure(call: Call<Movie_Response>, t: Throwable)
            {
                Toast.makeText(this@MainActivity,"No Response",Toast.LENGTH_SHORT)
            }

        })
       // APIService.Get_Top_Rated_Movies("0a01d24f102b98e78312e878be0e1e65")



    }
}