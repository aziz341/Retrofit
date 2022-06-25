package com.example.retrofit.domain.usecases

import com.example.retrofit.domain.Post
import com.example.retrofit.domain.Repository
import retrofit2.Response

class GetPostUseCase (private val repository: Repository){
    suspend fun getPost(postNum: Int):Response<Post>{
        return repository.getPost(postNum)
    }
}