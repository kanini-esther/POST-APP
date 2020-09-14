package com.example.postsapp.viewmodel

import androidx.lifecycle.MutableLiveData

class PostsViewModel(val postsRepository: PostsRepository): viewModel(){
    var postsLiveData = MutableLiveData<List<Post>>()

    fun getPosts(){
        viewModelScope.launch{
            val response = postsRepository.getPosts()
            if (response.isSuccessful){
                postLiveData.postValue(response.body())
            }
        }

    }
}
