package com.example.newsapi_kotlin.rec_V

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapi_kotlin.databinding.ListNewsBinding
import com.example.newsapi_kotlin.model.Article

class AdapterNews(val context: Context) : RecyclerView.Adapter<AdapterNews.NewsViewHolder>() {
    private lateinit var binding: ListNewsBinding
    var list: List<Article> = emptyList()

    class NewsViewHolder(private val binding: ListNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article,context: Context) {

            binding.tvAuthor.text = article.author
            binding.tvTitle.text = article.title
            binding.textView.text = article.description
            binding.tvPublished.text = article.publishedAt
            binding.tvUrl.text = article.url
            binding.textView2.text = article.content

            Glide.with(context).load(article.urlToImage).into(binding.imageView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        binding = ListNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(list[position],context)

    }

    override fun getItemCount(): Int {
        return list.size

    }

    fun setData(list: List<Article>) {
        this.list = list
        notifyDataSetChanged()
    }
}