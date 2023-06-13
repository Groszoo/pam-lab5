package pl.szadkowski.pamapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import pl.szadkowski.pamapp.retrofit.Post
import pl.szadkowski.pamapp.retrofit.PostAPI

class PostRepository(private val postApi: PostAPI): Repository<Post>() {

    fun addPost(post: Post): LiveData<Resource<Boolean>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            val data = callApi { postApi.addPost(post) }
            data.let {
                if (it.status == Status.SUCCESS) {
                    emit(Resource.success(true))
                } else {
                    emit(Resource.error(null, null))
                }
            }
        }
}