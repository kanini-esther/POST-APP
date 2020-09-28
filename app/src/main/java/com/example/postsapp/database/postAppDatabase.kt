package com.example.postsapp.database

import android.content.Context
import androidx.room.Database
import com.example.postsapp.models.Post

@Database(entities = arrayOf(Post::class), version = 1)
abstract class postAppDatabase {
    abstract fun postDao(): postsDao

    companion object{
        private var dbInstance: postAppDatabase? = null

        fun getDbInstance(context: Context):postAppDatabase{
            if (dbInstance==null){

        }
    }
}