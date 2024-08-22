package com.threads.app.ui.auth

import DatastoreManager
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import com.threads.app.R
import com.threads.app.ui.home.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var userId: EditText
    private lateinit var password: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        userId = findViewById(R.id.etUserId)
        password = findViewById(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val eyeIcon = findViewById<ImageView>(R.id.eyeIcon)

        eyeIcon.setOnClickListener {
            if (password.inputType == (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                // Show password
                password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                eyeIcon.setImageResource(R.drawable.ic_eye_off)
            } else {
                // Hide password
                password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                eyeIcon.setImageResource(R.drawable.ic_eye)
            }
            password.setSelection(password.text.length) // Move cursor to end
        }

        loginButton.setOnClickListener {
            val inputUserId = userId.text.toString().trim()
            val inputPassword = password.text.toString().trim()

            if (inputUserId == "admin" && inputPassword == "123456") {
                lifecycleScope.launch {
                    saveCredentials(inputUserId, inputPassword)
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                }
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }

    }


    private suspend fun saveCredentials(userId: String, password: String) {
        val datastoreManager = DatastoreManager(this)
        datastoreManager.saveString("user_id", userId)
        datastoreManager.saveString("password", password)
    }
}