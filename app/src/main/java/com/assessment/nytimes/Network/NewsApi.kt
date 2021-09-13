package com.assessment.nytimes.Network

import com.assessment.nytimes.Model.News

import retrofit2.Call
import retrofit2.http.GET

import retrofit2.http.Query

interface NewsApi {
    //https://api.nytimes.com/svc/mostpopular/v2/viewed/7.json?api-key=qLV02TGybZY2SY84ALpcW52IqDMdax7q
    @GET("viewed/7.json")
    fun getNews(@Query("api-key")
                apiKey:String

    ): Call<News>
}