package com.example.just20minutes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import androidx.core.view.isVisible
import java.util.*
import java.util.concurrent.TimeUnit

class HowDidItGoButtons : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_did_it_go_buttons)

        val toRelaxTimerButton = findViewById<Button>(R.id.toRelaxTimerButton)
        toRelaxTimerButton.setOnClickListener{
            val intent = Intent(this,RelaxTimer::class.java)
            startActivity(intent)
            finish()
        }

        val wentWellButton = findViewById<Button>(R.id.wentWellButton)
        wentWellButton.setOnClickListener{
            //val intent = Intent(this,whatever the item page is called::class.java)
            //startactivity(intent)
            finish()
        }

        val duration = TimeUnit.MINUTES.toMillis(1)
        var cinco = object : CountDownTimer(duration, 1000) {
            override fun onTick(l: Long) {
                //maybe we add the thing where the button becomes darker as we the time goes on
                }

            override fun onFinish() {
                //takes you to the item page whatever we end up calling it
                finish()
            }
        }
    }
}