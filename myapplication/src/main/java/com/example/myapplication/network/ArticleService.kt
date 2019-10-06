package com.example.myapplication.network

import com.example.myapplication.adapter.ArticleAdapter
import retrofit2.Call
import retrofit2.http.GET

interface ArticleService {
    @GET("everything?q=bitcoin&sortBy=publishedAt&apiKey=3189b63e6036413ca4811ff6b7f3b780")
    fun list(): Call<ArticleResponse>

}
class ArticleResponse(val status:String, val totalResults:Int ,val articles:List<ArticleAdapter.Article>) {

}
