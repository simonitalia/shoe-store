package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.navigateUp
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        //initialize the drawer layout
        drawerLayout = binding.drawerLayout

        //get Navigation Controller
        val navigationController = this.findNavController(R.id.mainNavHostFragment)

        //Create an appBarConfiguration with the navController.graph
        appBarConfiguration = AppBarConfiguration(navigationController.graph, drawerLayout)

        //Setup / hookup the Navigation Controller UI with the Action Bar
        NavigationUI.setupActionBarWithNavController(this, navigationController, drawerLayout)

        //Hook up the navigation UI up to the navigation view.
        NavigationUI.setupWithNavController(binding.navView, navigationController)

        appDrawerListener(navigationController)

        Timber.plant(Timber.DebugTree())
    }

    override fun onSupportNavigateUp(): Boolean {

        //get Navigation Controller
        val navigationController = this.findNavController(R.id.mainNavHostFragment)
        return navigateUp(navigationController, drawerLayout)
    }

    private fun appDrawerListener(navigationController: NavController) {
        // prevent nav gesture if not on start destination
        navigationController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, _: Bundle? ->
            if (nd.id == nc.graph.startDestination) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            } else {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }
    }
}
