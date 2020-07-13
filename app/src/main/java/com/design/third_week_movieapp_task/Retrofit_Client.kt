package com.design.third_week_movieapp_task

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit_Client
{
    private var Retrofit_Client: Retrofit? = null

    fun Get_Retrofit_Client(): Retrofit
    {
        if(Retrofit_Client == null)
            Retrofit_Client = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        return Retrofit_Client!!
    }
}