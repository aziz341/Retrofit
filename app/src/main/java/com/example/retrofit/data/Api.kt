package com.example.retrofit.data

import com.example.retrofit.domain.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("posts")
    suspend fun getAllPosts(): Response<MutableList<Post>>

    @GET("posts/{postNumber}")
    suspend fun getPost(
        @Path("postNUmber") postNum: Int
    ): Response<Post>

    @GET("posts")
    suspend fun getPostsById(
        @Query("userId") userId: Int
    ): Response<MutableList<Post>>

    @GET("posts")
    suspend fun getSortPosts(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<MutableList<Post>>
}