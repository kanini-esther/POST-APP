package com.example.postsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postsapp.R
import com.example.postsapp.models.Post
import com.example.postsapp.models.id
import com.example.postsapp.viewmodel.PostsViewModel

class PostsAdapter(var posts:List<Post>):
        RecyclerView.Adapter<PostsAdapter.PostsViewHolder>()
{
    override fun onCreatViewHolder(parent: ViewGroup, viewType:Int)=PostsViewModel
    ewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_posts,parent,false)
    )

    override fun getItemCount() = posts.size

    override onBindViewHolder(holder:PostsViewHolder,position:Int){
    var post = posts[position]

    holder.itemView.userId.text = post.userId.toString()
    holder.itemView.idt.text=post..id.toString()
    holder.itemView.title.text=post.tittle
    holder.itemView.body.text = post.body
}
   inner class
           postsViewHolder(itemView):
           RecyclerView.ViewHolder(itemView)
}