package com.example.postsapp.ui

import com.example.postsapp.models.Post

interface postItemClickListener {
    fun onItemClick(post: Post)
}