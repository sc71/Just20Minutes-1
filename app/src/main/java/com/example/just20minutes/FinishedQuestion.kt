package com.example.just20minutes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FinishedQuestion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finished_question)

        val goToSixtySecondsTimer = findViewById<Button>(R.id.goToSixtySecondsTimer)
        goToSixtySecondsTimer.setOnClickListener{
            val intent = Intent(this,SixtySeconds::class.java)
            startActivity(intent)
            finish()
        }

        val finishedWithAppButton = findViewById<Button>(R.id.finishedWithAppButton)
        finishedWithAppButton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}