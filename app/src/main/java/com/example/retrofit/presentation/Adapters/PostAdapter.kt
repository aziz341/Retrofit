package com.example.retrofit.presentation.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.databinding.PostItemBinding
import com.example.retrofit.domain.Post

class PostAdapter: RecyclerView.Adapter<PostAdapter.Holder>() {
    var postList: MutableList<Post> = mutableListOf()
    @SuppressLint("NotifyDataSetChanged")
    set(value){
        field = value
        notifyDataSetChanged()
    }

    inner class Holder(view: View):RecyclerView.ViewHolder(view){
        private val uId = view.findViewById<TextView>(R.id.user_Id)
        private val pId = view.findViewById<TextView>(R.id.textView3)
        private val postTitle = view.findViewById<TextView>(R.id.textView2)
        private val postBody = view.findViewById<TextView>(R.id.textView7)

        fun bind(post:Post){
            post.apply{
                uId.text = userId.toString()
                pId.text = postId.toString()
                postTitle.text = title
                postBody.text = body
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item,parent,false)
        return Holder(view = view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(post = postList[position])
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}