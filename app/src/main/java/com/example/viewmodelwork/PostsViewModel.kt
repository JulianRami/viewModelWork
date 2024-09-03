package com.example.viewmodelwork

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostsViewModel : ViewModel() {

    private val _uiState = MutableLiveData<CloneXUIState>()
    val uiState: LiveData<CloneXUIState> get() = _uiState

    init {
        loadPosts()
    }

    private fun loadPosts() {
        _uiState.value = CloneXUIState(isLoading = true)

        val posts = List(10) { i -> Post("Username $i") }
        _uiState.value = CloneXUIState(posts = posts)
    }
}