package com.example.retrofit.domain

import com.google.gson.annotations.SerializedName

data class Post (
    val userId : Int,
    @SerializedName("id")
    val postId : Int,
    val title:String,
    val body :String
        )