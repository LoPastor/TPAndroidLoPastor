package com.example.myapplication.network.repository

import com.example.myapplication.adapter.ArticleAdapter
import com.example.myapplication.network.ArticleService
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticlepReository {
    private val service: ArticleService
    init {
        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://newsapi.org/v2/")
        }.addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(ArticleService::class.java)
    }
    fun list(): List<ArticleAdapter.Article> {
        val response = service.list().execute()
        return response.body()?.articles ?: emptyList()
    }
}