package com.example.just20minutes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.isVisible
import java.util.*
import java.util.concurrent.TimeUnit

class HowDidItGoButtons : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_did_it_go_buttons)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar_howDidItGo_timer)

        val toRelaxTimerButton = findViewById<Button>(R.id.button_howDidItGo_timer)
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
        val startTime = 2000
        var timeLeftInMillis = startTime
        var cinco = object : CountDownTimer(duration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished.toInt()
                progressBar.progress = (millisUntilFinished/100).toInt()

                //maybe we add the thing where the button becomes darker as we the time goes on
                }

            override fun onFinish() {
                //takes you to the item page whatever we end up calling it
                finish()
            }
        }
        cinco.start()
    }
}