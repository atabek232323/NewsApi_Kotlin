package com.example.newsapi_kotlin.data.remote

import com.example.newsapi_kotlin.model.Article.NewsApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInistance {
    @GET("v2/everything")
     suspend fun getNews(@Query("q")newsType:String,@Query("from")data:String ,@Query("sortBy")sortBy:String,@Query("apiKey")apiKey:String):Response<NewsApi>
}//v2/everything?=tesla&from=2021-10-28&sortBy=publishedAt&apiKey=