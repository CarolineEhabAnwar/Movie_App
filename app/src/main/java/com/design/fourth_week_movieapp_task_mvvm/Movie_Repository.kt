package com.design.fourth_week_movieapp_task_mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Movie_Repository
{
    private val tag: String = MainActivity::class.java.simpleName
    private lateinit var APIService: API_Service
    private val Popular_Movies_List: MutableList<Movie> = mutableListOf()
    private val Top_Movies_List: MutableList<Movie> = mutableListOf()


    fun Click_Popular() : LiveData<List<Movie>>
    {
        val moviesListLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

        if (Popular_Movies_List.size > 0)
        {
            moviesListLiveData.postValue(Popular_Movies_List)
            return moviesListLiveData
        }

        APIService = Retrofit_Client.Get_Retrofit_Client().create(API_Service::class.java)
        APIService.Get_Popular_Movies("0a01d24f102b98e78312e878be0e1e65")
            .enqueue(object : Callback<Movie_Response> {

                override fun onResponse(call: Call<Movie_Response>, response: Response<Movie_Response>) {
                    if (response.isSuccessful)
                    {
                        val remoteMoviesList: List<Movie> = response.body()?.results ?: listOf()
                        Popular_Movies_List.addAll(remoteMoviesList)
                        moviesListLiveData.postValue(Popular_Movies_List)
                    }
                }

                override fun onFailure(call: Call<Movie_Response>, t: Throwable) {
                    Log.e(tag, t.message.toString())
                }

            })
        return moviesListLiveData

    }

    fun Click_Top_Rated() : LiveData<List<Movie>>
    {
        val moviesListLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

        if (Top_Movies_List.size > 0)
        {
            moviesListLiveData.postValue(Top_Movies_List)
            return moviesListLiveData
        }

        APIService = Retrofit_Client.Get_Retrofit_Client().create(API_Service::class.java)
        APIService.Get_Top_Rated_Movies("0a01d24f102b98e78312e878be0e1e65")
            .enqueue(object : Callback<Movie_Response> {

                override fun onResponse(
                    call: Call<Movie_Response>,
                    response: Response<Movie_Response>
                ) {
                    if (response.isSuccessful)
                    {
                        val remoteMoviesList: List<Movie> = response.body()?.results ?: listOf()
                        Top_Movies_List.addAll(remoteMoviesList)
                        moviesListLiveData.postValue(Top_Movies_List)
                    }
                }

                override fun onFailure(call: Call<Movie_Response>, t: Throwable) {
                    Log.e(tag, t.message.toString())
                }

            })
        return moviesListLiveData

    }


}