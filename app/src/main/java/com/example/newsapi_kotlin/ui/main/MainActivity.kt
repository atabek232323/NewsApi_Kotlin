package com.example.newsapi_kotlin.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapi_kotlin.databinding.ActivityMainBinding
import com.example.newsapi_kotlin.rec_V.AdapterNews
import com.example.newsapi_kotlin.repazitori.Repazitori

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainVievModel: MainVievModel
    private lateinit var mainVievModelProvider: MainVievModelProvider
    private val TAG = "MainActivity"
    val adapter by lazy { AdapterNews(applicationContext) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVievModel()
        getNewsFromApi()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerview.layoutManager = LinearLayoutManager(applicationContext)

    }

    private fun getNewsFromApi() {
        mainVievModel.getNews(
            "sport",
            "29.11.2021",
            "publishAt",
            "99656d7c382d4660b383a7461d5ba94f"
        )
        mainVievModel.mynews.observe(this, Observer {
            if (it.isSuccessful && it.body() != null){
            adapter.setData(it.body()!!.articles)
            binding.recyclerview.adapter = adapter
        }
            else {
            Log.d(TAG, "getNewsFromApi: " + it.errorBody().toString())
        }

        })
    }

    private fun initVievModel() {
        val repazitori = Repazitori()
        mainVievModelProvider = MainVievModelProvider(repazitori)
        mainVievModel =
            ViewModelProvider(this, mainVievModelProvider).get(MainVievModel::class.java)

    }
}