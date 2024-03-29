package pl.szadkowski.pamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import pl.szadkowski.pamapp.databinding.ActivityMainBinding
import pl.szadkowski.pamapp.extensions.switchTo


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogIn.setOnClickListener { switchTo(HomeActivity::class.java) }
        binding.buttonAdd.setOnClickListener { switchTo(PostActivity::class.java) }
        binding.buttonList.setOnClickListener{ switchTo(PostListActivity::class.java)}

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.main_menu_about -> {
                switchTo(AboutActivity::class.java)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}