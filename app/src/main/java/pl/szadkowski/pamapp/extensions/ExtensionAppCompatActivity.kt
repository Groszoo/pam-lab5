package pl.szadkowski.pamapp.extensions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

fun <T> AppCompatActivity.switchTo(cls: Class<T>) {
    val intent = Intent(this, cls)
    startActivity(intent)
}