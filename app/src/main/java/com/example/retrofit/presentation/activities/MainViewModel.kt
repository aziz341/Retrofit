package com.example.retrofit.presentation.activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.domain.Post
import com.example.retrofit.domain.Repository
import com.example.retrofit.domain.usecases.GetAllPostsUseCase
import com.example.retrofit.domain.usecases.GetPostUseCase
import com.example.retrofit.domain.usecases.GetPostsByUserIdUseCase
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel() : ViewModel() {
    private val repository = Repository()

    private val getAllPostsUseCase = GetAllPostsUseCase(repository)
    private val getPostUseCase = GetPostUseCase(repository)
    private val getPostsByUserIdUseCase = GetPostsByUserIdUseCase(repository)

    private val _allPosts: MutableLiveData<Response<MutableList<Post>>> = MutableLiveData()
    val allPosts: LiveData<Response<MutableList<Post>>>
        get() = _allPosts

    private val _getSortedPosts : MutableLiveData<Response<Post>> = MutableLiveData()
    val sort : MutableLiveData<Response<Post>>
    get() = _getSortedPosts
    private val _post: MutableLiveData<Response<Post>> = MutableLiveData()
    val post : LiveData<Response<Post>>
        get() = _post

    private val _postsByUserId:MutableLiveData<Response<MutableList<Post>>> = MutableLiveData()
    val postsByUserId : LiveData<Response<MutableList<Post>>>
        get() = _postsByUserId

    init {
        getAllPosts()
    }

    private  fun getAllPosts(){
        viewModelScope.launch {
            _allPosts.value = getAllPostsUseCase.getAllPostsUseCases()
        }
    }
    fun getPost(postNum : Int){
        viewModelScope.launch {
            _post.value = getPostUseCase.getPost(postNum)
        }
    }

    fun getPostsByUserId(userId:Int){
        viewModelScope.launch {
            _postsByUserId.value = getPostsByUserIdUseCase.execute(userId)
        }
    }
    fun getSortedPosts(userId: Int,_sort :String,order :String){
        viewModelScope.launch {
            _getSortedPosts.value = getAllPostsUseCase.getS(userId,_sort)
        }
    }

}
