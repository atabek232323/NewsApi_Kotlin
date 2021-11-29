package com.example.newsapi_kotlin.repazitori

import com.example.newsapi_kotlin.data.remote.NewsRetro_Init
import com.example.newsapi_kotlin.model.Article.NewsApi
import retrofit2.Response

class Repazitori {
    suspend fun getNews (newsType:String,data:String,sortBy:String,apikey:String):Response<NewsApi>{
       return NewsRetro_Init.api.getNews(newsType,data,sortBy,apikey)
    }
}