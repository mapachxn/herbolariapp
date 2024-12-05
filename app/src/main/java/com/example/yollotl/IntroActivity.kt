package com.example.yollotl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

            val nextButton:  Button = findViewById(R.id.btn_next)
        nextButton.setOnClickListener {
            val intent = Intent(this, IntroActivity2::class.java)
            startActivity(intent)

            }
        }
    }
