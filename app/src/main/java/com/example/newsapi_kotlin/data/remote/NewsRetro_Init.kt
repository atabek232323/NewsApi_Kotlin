package com.example.newsapi_kotlin.data.remote

import com.example.newsapi_kotlin.model.Article.NewsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsRetro_Init {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://newsapi.org/").addConverterFactory(GsonConverterFactory.create()).build()
    }
    val api by  lazy {
        retrofit.create(NewsApiInistance::class.java)
    }
}