package com.example.viewmodelwork

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapterPosts(private val posts: List<Post>,
                     private val itemClick: (Post) -> Unit
) : RecyclerView.Adapter<RVAdapterPosts.PostViewHolder>() {

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUserName: TextView = view.findViewById(R.id.tvUsername)
        val ibLike: ImageButton = view.findViewById(R.id.ibLike)
        val ibComment: ImageButton = view.findViewById(R.id.ibComment)
        val ibRepost: ImageButton = view.findViewById(R.id.ibRepost)
        val ibMetrics: ImageButton = view.findViewById(R.id.ibMetrics)
        val ibExpand: ImageButton = view.findViewById(R.id.ibExpand)


        init {
            ibLike.setOnClickListener {
                itemClick.invoke(posts[adapterPosition])
            }
            ibComment.setOnClickListener {
                itemClick.invoke(posts[adapterPosition])
            }
            ibMetrics.setOnClickListener {
                itemClick.invoke(posts[adapterPosition])
            }
            ibRepost.setOnClickListener {
                itemClick.invoke(posts[adapterPosition])
            }
            ibExpand.setOnClickListener {
                itemClick.invoke(posts[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.tvUserName.text = posts[position].userName
    }

    override fun getItemCount(): Int = posts.size
}