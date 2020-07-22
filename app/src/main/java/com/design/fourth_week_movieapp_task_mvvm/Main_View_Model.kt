package com.design.fourth_week_movieapp_task_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class Main_View_Model : ViewModel() {

    fun get_Top_Movies(): LiveData<List<Movie>> {
        return Movie_Repository.Click_Top_Rated()
    }

    fun get_Popular_Movies(): LiveData<List<Movie>> {
        return Movie_Repository.Click_Popular()
    }


}