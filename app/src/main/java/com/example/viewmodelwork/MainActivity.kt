package com.example.viewmodelwork

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val viewModel: PostsViewModel by viewModels()
    private lateinit var rvPosts: RecyclerView
    private val postList = arrayListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        observeViewModel()
    }

    private fun initViews() {
        rvPosts = findViewById(R.id.rv_posts)
        rvPosts.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
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

}
