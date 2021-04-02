package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        //get Navigation Controller
//        val navigationController = this.findNavController(R.id.mainNavHostFragment)

        //Setup / hookup the Navigation Controller UI with the Action Bar
//        NavigationUI.setupActionBarWithNavController(this, navigationController)

        //Create an appBarConfiguration with the navController.graph and drawerLayout
//        appBarConfiguration = AppBarConfiguration(navigationController.graph)

        Timber.plant(Timber.DebugTree())
    }
}
