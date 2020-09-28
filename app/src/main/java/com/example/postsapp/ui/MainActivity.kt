package com.example.postsapp.ui

import android.content.Intent
import android.database.Observable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.postsapp.R
import com.example.postsapp.models.Post
import com.example.postsapp.repository.PostRepository
import com.example.postsapp.viewmodel.PostsViewModel
import com.example.postsapp.viewmodel.PostsViewModelFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var postsViewModel: PostsViewModel
    lateinit var postsViewFactory: PostsViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PostsViewModelFactory = PostsViewModelFactory(PostRepository())
        postsViewModel =
            ViewModelProvider(this, PostsViewModelFactory).get(PostsViewModel::class.java)

        postsViewModel.getDbPosts()

        postsViewModel.postsLiveData.observe(this, androidx.lifecycle.Observer {
            Post
            if (Posts.isEmpty()) {
                postsViewModel.getApiPosts()
            } else {
                val postsAdapter = PostsAdapter(Post, this)
                rvPosts.apply {
                    RecyclerView.LayoutManager = LinearLayoutManager(baseContext)
                    adapter = PostsAdapter
                }
            }
        })
        postsViewModel.postsFailedLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })

        override fun onItemClick(post: Post) {
            val intent = Intent(baseContext, CommentsActivity::class.java)
            intent.putExtra("POST_ID", post.id)
            startActivity(intent)
        }

    }
}
