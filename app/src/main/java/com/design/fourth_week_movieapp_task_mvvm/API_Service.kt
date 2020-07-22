package com.design.fourth_week_movieapp_task_mvvm

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface API_Service
{
    @GET("movie/popular")
    fun Get_Popular_Movies(@Query("api_key") apiKey: String): Call<Movie_Response>
    @GET("movie/top_rated")
    fun Get_Top_Rated_Movies(@Query("api_key") apiKey: String): Call<Movie_Response>
    @GET("movie/{movie_id}")
    fun Get_Movie_Details(@Query("api_key") apiKey: String): Call<Movie_Response>

}