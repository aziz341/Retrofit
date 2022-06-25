package com.example.retrofit.domain.usecases

import com.example.retrofit.domain.Post
import com.example.retrofit.domain.Repository
import retrofit2.Response

class GetAllPostsUseCase (
    private val repository: Repository
        ){
    suspend fun getAllPostsUseCases(): Response<MutableList<Post>>{
        return repository.getAllPosts()
    }
}