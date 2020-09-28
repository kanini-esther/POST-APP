package com.example.postsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.postsapp.R
import com.example.postsapp.repository.PostRepository
import com.example.postsapp.viewmodel.PostsViewModel
import com.example.postsapp.viewmodel.PostsViewModelFactory
import kotlinx.android.synthetic.main.activity_comments.*

class CommentsActivity : AppCompatActivity() {
    var postId: Int = 0
    lateinit var postsViewModel: PostsViewModel
    lateinit var postsViewModelFactory: PostsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        postId = intent.getIntExtra("POST_ID", defaultValue:0)

        postsViewModelFactory = postsViewModelFactory(PostRepository())
        postsViewModel =
            ViewModelProvider(this,postsViewModelFactory).get(PostsViewModel::class.java)

        postsViewModel.getPostById(postId)

    }

    override fun onResume() {
        super.onResume()
        postsViewModel.postsFailedLiveData.observe(this,{post->
           tvTitle.text = post.title
            tvBody.text = post.body
        })
    }
}