package com.threads.app.ui.splash

import DatastoreManager
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import com.threads.app.R
import com.threads.app.ui.auth.LoginActivity
import com.threads.app.ui.home.MainActivity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)


        Handler(Looper.getMainLooper()).postDelayed({
            checkUserLoginStatus()
        }, 3500) // 1.5 seconds delay


    }

    private fun checkUserLoginStatus() {
        val datastoreManager = DatastoreManager(this)

        // Fetch the user_id using a coroutine
        lifecycleScope.launch {
            val userIdKey = "user_id"
            val userId = datastoreManager.getString(userIdKey, null).first()

            if (userId != null) {
                // User is logged in, navigate to the main activity
               
                navigateToMainActivity()
            } else {
                // User is not logged in, navigate to the login activity
                navigateToLoginActivity()
            }
        }
    }


    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}