package pl.szadkowski.pamapp.retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PostAPI {

    @POST("posts")
    suspend fun addPost(@Body post: Post): Response<Post>
}