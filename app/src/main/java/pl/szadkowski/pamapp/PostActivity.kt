package pl.szadkowski.pamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import pl.szadkowski.pamapp.retrofit.Post
import pl.szadkowski.pamapp.retrofit.RetrofitBuilder
import pl.szadkowski.pamapp.databinding.ActivityCommentBinding
import com.google.android.material.textfield.TextInputEditText


class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommentBinding
    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MyViewModelFactory(PostRepository(RetrofitBuilder.apiService))).get(PostViewModel::class.java)
        binding.add.setOnClickListener {
            viewModel.addPosts(
                Post(
                    title = binding.author.editText?.text.toString(),
                    body = binding.comment.editText?.text.toString(),
                    userId = 2
                )
            ).observe(this) {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            Toast.makeText(this, "Success!", Toast.LENGTH_LONG).show()
                        }
                        Status.ERROR -> {
                            Toast.makeText(this, "Error!", Toast.LENGTH_LONG).show()
                        }
                        Status.LOADING -> {
                            Toast.makeText(this, "Loading!", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }

    }
}