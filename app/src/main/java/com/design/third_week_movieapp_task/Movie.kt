package com.design.third_week_movieapp_task

data class Movie(
    val poster_path: String? = null,
    val overview: String,
    val release_date: String,
    val id: Int,
    val title: String,
    val original_language: String,
    val popularity: Number,
    val vote_average: Number
)