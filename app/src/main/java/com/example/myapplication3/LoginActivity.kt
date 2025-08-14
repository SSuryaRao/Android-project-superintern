package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication3.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set an OnClickListener for the Sign In button
        binding.buttonSignIn.setOnClickListener {
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()

                // --- THIS IS THE CRUCIAL PART ---
                // This Intent tells the app to open DashboardActivity.
                // Make sure it says "DashboardActivity::class.java".
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)

                // Close the login activity so the user can't press "back" to return to it
                finish()
            }
        }

        binding.textViewForgotPassword.setOnClickListener {
            Toast.makeText(this, "Forgot Password clicked!", Toast.LENGTH_SHORT).show()
        }

        binding.textViewSignUp.setOnClickListener {
            Toast.makeText(this, "Sign Up clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}