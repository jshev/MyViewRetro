package com.example.myviewretro

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetroApiInterface {
    //singleton
    @GET("books.json")
    suspend fun getAllBooks() : Response<List<Books>>

    @POST("/post")
    suspend fun createBooks(@Body requestBody : RequestBody) : Response<ResponseBody>

    companion object {
        //var BASE_URL = "https://pokeapi.co/api/v2/"
        var BASE_URL = "https://thapasabiran.github.io/Data/"
        fun create(): RetroApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetroApiInterface::class.java)
        }
    }
}