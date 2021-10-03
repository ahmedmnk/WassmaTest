package com.amnk.wassmatest.app

import android.app.Application
import android.content.Context

class Wasapplication : Application() {
    companion object
    {
//        lateinit var database : WasDatabase
        private lateinit var instance : Wasapplication

        fun getAppContext(): Context = instance.applicationContext
    }
    override fun onCreate() {
        instance = this
        super.onCreate()


    }

}