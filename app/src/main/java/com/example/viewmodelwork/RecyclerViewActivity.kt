package com.example.viewmodelwork

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewActivity : AppCompatActivity() {

    private val viewModel: PostsViewModel by viewModels()
    private lateinit var rvPosts: RecyclerView
    private val postList = arrayListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        fillPostList()
        initViews()
    }

    private fun initViews() {
        rvPosts = findViewById(R.id.rv_posts)
        rvPosts.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
            adapter = RVAdapterPosts(postList)
        }
    }

    private fun observeViewModel() {
        viewModel.uiState.observe(this) { uiState ->
            uiState.posts.let {
                rvPosts.adapter = RVAdapterPosts(it)
            }
        }
    }

    private fun fillPostList() {
        for (i in 0 until 10) {
            postList.add(Post("Username $i"))
        }
    }
}