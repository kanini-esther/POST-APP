package com.example.postsapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postsapp.models.Post

@Dao
interface postsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(post: Post)

    @Query("SELECT * FROM Post")
    fun getPosts(): LiveData<List<Post>>

    @Query("SELECT * FROM Post WHERE id = :PostId")
    fun getpostById(postId: Int): LiveData<Post>

}