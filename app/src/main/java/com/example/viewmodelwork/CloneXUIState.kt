package com.example.viewmodelwork


data class CloneXUIState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
