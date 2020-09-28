package com.example.postsapp.api

import com.example.postsapp.models.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>> = withContext(Dispatchers.IO){
        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val response = apiClient.getPosts()
        response

    }
}