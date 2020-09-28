package com.example.postsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.postsapp.models.Post
import com.example.postsapp.repository.PostRepository

class PostsViewModel(val postsRepository: PostRepository): viewModel(){
     lateinit var postsLiveData = LiveData<List<Post>>
    var postsFailedLiveData = MutableLiveData<String>()

    fun getApiPosts(){
        viewModelScope.launch {
            val response = postsRepository.getPosts()
            if (!response.isSuccessful){
                postsFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
    fun getDbPosts(){
        postsLiveData = postsRepository.getDbPosts()

    }
    fun getPostById(postId:Int)
    postByIdLiveData = postsRepository.getPostById(PostId)

}
