package com.example.postsapp.viewmodel

import android.app.Application

class postsApp: Application(){
    override fun onCreate(){
        super.onCreate()
        postsApp.appContext = applicationContext
    }
}