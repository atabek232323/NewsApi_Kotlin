package com.example.newsapi_kotlin.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapi_kotlin.model.Article
import com.example.newsapi_kotlin.repazitori.Repazitori
import kotlinx.coroutines.launch
import retrofit2.Response

class MainVievModel(val repazitori: Repazitori) : ViewModel() {
    val mynews: MutableLiveData<Response<Article.NewsApi>> = MutableLiveData()
    fun getNews(newsType:String,data:String,sortBy:String,apikey:String) {
        viewModelScope.launch {
          val result = repazitori.getNews(newsType,data,sortBy,apikey)
            mynews.value = result
        }
    }

}