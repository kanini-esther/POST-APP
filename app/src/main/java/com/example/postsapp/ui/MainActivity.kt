package com.example.postsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.postsapp.R
import com.example.postsapp.viewmodel.PostsViewModel
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var postsViewModel: PostsViewModel
    lateinit var postsViewFactory: GsonConverterFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postsRepository = postsRepository()
        postsViewFactory = postsViewModelFactory(postsRepository)
        postsViewModel = ViewModelProvider(this,postsViewModelFactory).get(PostsViewModel::class.java)
    }
}