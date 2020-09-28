package com.example.postsapp.repository

import android.renderscript.Script
import androidx.lifecycle.LiveData
import com.example.postsapp.api.ApiClient
import com.example.postsapp.api.ApiInterface
import com.example.postsapp.database.postAppDatabase
import com.example.postsapp.models.Post
import com.example.postsapp.viewmodel.postsApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.withContext
import okhttp3.Response

class PostRepository (){
    suspend fun getPosts(): Response<List<Post>> = withContext(Dispatchers.IO + NonCancellable){
        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val response = apiClient.getPosts()
        if (response.isSuccessful){
            val post = response.body() as List<Post>
            savePosts(Post)
        }
        return@withContext
    }
    suspend fun savePosts(postslist: List<Post>) = withContext(Dispatchers.IO){
        val database = postAppDatabase(postsApp.appContext)
        postslist.forEach { Post->
            database.postDao().insertPost(Post)

        }
    }
    fun getDbPosts(): LiveData<List<Post>>{
        val database = postAppDatabase.getDbInstance(postsApp.appContext)
        return database.postDao().getPosts()
    }
    fun getPostById(postId: Int): LiveData<Post>{
        val database = postAppDatabase.getDbInstance(postsApp.appContext)
        return database.postDao().getpostById(postId)
    }
}