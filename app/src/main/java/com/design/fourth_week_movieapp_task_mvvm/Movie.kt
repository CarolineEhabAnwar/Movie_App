package com.design.fourth_week_movieapp_task_mvvm

data class Movie(
    val poster_path: String? = null,
    val overview: String,
    val release_date: String,
    val title: String,
    val original_language: String,
    val popularity: Float,
    val vote_average: Float
)