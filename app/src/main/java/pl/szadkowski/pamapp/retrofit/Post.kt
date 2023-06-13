package pl.szadkowski.pamapp.retrofit

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("id") var id: Long? = null,
    @SerializedName("userId") var userId: Long? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("body") var body: String? = null
)