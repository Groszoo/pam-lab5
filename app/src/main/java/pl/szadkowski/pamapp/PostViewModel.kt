package pl.szadkowski.pamapp

import androidx.lifecycle.ViewModel
import pl.szadkowski.pamapp.retrofit.Post

class PostViewModel(private val postRepository: PostRepository): ViewModel() {

    fun addPosts(post: Post) = postRepository.addPost(post)
}