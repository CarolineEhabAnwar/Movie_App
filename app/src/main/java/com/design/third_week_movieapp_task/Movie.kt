package com.design.third_week_movieapp_task

data class Movie(
    val poster_path: String? = null,
    val overview: String,
    val release_date: String,
    val title: String,
    val original_language: String,
    val popularity: Float,
    val vote_average: Float
)