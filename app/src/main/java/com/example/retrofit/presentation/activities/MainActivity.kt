package com.example.retrofit.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.R
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.presentation.Adapters.PostAdapter

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    var adapter: PostAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.mainRv.hasFixedSize()
        adapter = PostAdapter()

        observeViewModel()
        binding.button.setOnClickListener {
            val num = binding.editTextTextPersonName.text.toString().toInt()
//            viewModel.getPostsByUserId(num)
            viewModel.getSortedPosts(num"id",desc)
        }
    }

    private fun observeViewModel() {


        viewModel.sortedPosts.observe(this){
            if (it.isSuccessful){
                adapter?.postList = it.body()!!
                binding.mainRv.adapter = adapter
            }
        }
        viewModel.allPosts.observe(this) {
            if (it.isSuccessful) {
                adapter?.postList = it.body()!!
                binding.mainRv.adapter = adapter
            }
        }
        viewModel.postsByUserId.observe(this) {
            if (it.isSuccessful) {
                adapter?.postList = it.body()!!
                binding.mainRv.adapter = adapter
            }
        }
        viewModel.post.observe(this) {
            if (it.body() != null) {
                adapter?.postList?.clear()
                adapter?.postList?.add(it.body()!!)
                binding.mainRv.adapter = adapter
            }
        }
    }
}
