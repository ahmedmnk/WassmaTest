package com.amnk.wassmatest.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes LayoutRes : Int, attachRoot: Boolean = false) : View
{
    return LayoutInflater.from(context).inflate(LayoutRes,this,attachRoot)
}