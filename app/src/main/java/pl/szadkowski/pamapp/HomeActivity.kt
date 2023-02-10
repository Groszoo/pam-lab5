package pl.szadkowski.pamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import pl.szadkowski.pamapp.databinding.ActivityHomeBinding
import pl.szadkowski.pamapp.fragments.ChatFragment
import pl.szadkowski.pamapp.fragments.NotesFragment
import pl.szadkowski.pamapp.fragments.ProfileFragment

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var drawerLayout: DrawerLayout
    private val fragmentContainer get() = R.id.fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        drawerLayout = binding.drawerLayout
        val toogle = ActionBarDrawerToggle(this,  drawerLayout, toolbar,
            R.string.open_navigation_bar, R.string.close_navigation_bar)

        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        val navigationView = binding.navigatioView
        navigationView.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(fragmentContainer, ProfileFragment()).commit()
            navigationView.setCheckedItem(R.id.drawer_profile)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.drawer_profile -> supportFragmentManager.beginTransaction().replace(fragmentContainer, ProfileFragment()).commit()
            R.id.drawer_chat -> supportFragmentManager.beginTransaction().replace(fragmentContainer, ChatFragment()).commit()
            R.id.drawer_notes -> supportFragmentManager.beginTransaction().replace(fragmentContainer, NotesFragment()).commit()
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}