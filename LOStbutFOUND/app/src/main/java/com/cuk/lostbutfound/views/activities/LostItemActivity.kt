package com.cuk.lostbutfound.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.cuk.lostbutfound.R
import com.cuk.lostbutfound.databinding.ActivityLostItemBinding

class LostItemActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityLostItemBinding
    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityLostItemBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mNavController = findNavController(R.id.navHost)

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.lostItemFragment, R.id.postFragment
        ))
        setupActionBarWithNavController(mNavController, appBarConfiguration)
        mainBinding.bottomNav.setupWithNavController(mNavController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return mNavController.navigateUp() || super.onSupportNavigateUp()
    }
}