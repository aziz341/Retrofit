package com.example.retrofit.domain.usecases

import com.example.retrofit.domain.Post
import com.example.retrofit.domain.Repository
import retrofit2.Response

class GetPostsByUserIdUseCase(
    val repository: Repository
){
    suspend fun execute(userId : Int):Response<MutableList<Post>>{
        return repository.getPostsById(userId)
    }
}