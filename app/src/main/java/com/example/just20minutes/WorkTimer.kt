package com.example.just20minutes

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import java.util.*
import java.util.concurrent.TimeUnit

class WorkTimer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_timer)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        var seekBar = findViewById<SeekBar>(R.id.setTimeSeekBar)
        var timeTextView = findViewById<TextView>(R.id.timeSetTextView)
        var userSetTime = 0

        var startTimeText = "10 min"
        timeTextView.setText(startTimeText)

        val goToMain = Intent(this,MainActivity::class.java)
        var duration = TimeUnit.MINUTES.toMillis(seekBar.progress.toLong())

        val PRIVATE_MODE = 0
        val PREF_NAME = "a"
        var sharedPreferences : SharedPreferences = getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        //seekbar
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, p1: Int, p2: Boolean) {
                var timeToDisplay = seek.progress.toString() + " min"
                timeTextView.setText(timeToDisplay)
                duration = TimeUnit.MINUTES.toMillis(seekBar.progress.toLong())
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                userSetTime = seek.progress
                duration = TimeUnit.MINUTES.toMillis(seekBar.progress.toLong())
            }
        })

        val startTimerButton = findViewById<Button>(R.id.startWorkTimerButton)
        startTimerButton.isVisible = true
        startTimerButton.setOnClickListener {
            var zero: Long = 0
            if(duration != zero) {
                var timeToCount = object : CountDownTimer(duration, 1000) {
                    override fun onTick(timeLeft: Long) {
                        var sDuration = String.format(
                            Locale.ENGLISH, "%02d : %02d",
                            TimeUnit.MILLISECONDS.toMinutes(timeLeft),
                            TimeUnit.MILLISECONDS.toSeconds(timeLeft) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeLeft)))
                        timeTextView.text = sDuration
                    }

                    override fun onFinish() {
                        Toast.makeText(applicationContext, "timer complete!", Toast.LENGTH_SHORT).show()
                        var editor = sharedPreferences.edit()
                        //editor.putInt("time", TimeUnit.MILLISECONDS.toMinutes(duration).toInt())
                        startActivity(goToMain)
                        finish()
                    }
                }
                timeToCount.start()
                startTimerButton.isVisible = false
                seekBar.isVisible = false
            }
        }
    }

    override fun onBackPressed() {
        val goBackPlease = Intent(this,FinishedQuestion::class.java)
        startActivity(goBackPlease)
        finish()
    }
}