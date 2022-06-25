package com.example.retrofit.domain

import com.example.retrofit.data.Api
import com.example.retrofit.data.RetrofitInstanse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Query

class Repository : Api {
    override suspend fun getAllPosts():Response<MutableList<Post>>{
        return RetrofitInstanse.api.getAllPosts()
    }

    override suspend fun getPost(postNum: Int): Response<Post> {
        return RetrofitInstanse.api.getPost(postNum)
    }

    override suspend fun getPostsById(userId: Int): Response<MutableList<Post>> {
        return RetrofitInstanse.api.getPostsById(userId)
    }

    override suspend fun getSortPosts(userId: Int, sort: String, order: String):
            Response<MutableList<Post>> {
        return RetrofitInstanse.api.getSortPosts(userId,sort,order)
    }

    override suspend fun getAllPostsSorted (
        @Query(value = "userId") userId:Int,
        @Query(value = "_sort") sort : String,
        @Query(value = "_order")order : String
        ):Response<MutableList<Post>>{
        return RetrofitInstanse.api.getAllPostsSorted(userId,sort,order)
    }
}