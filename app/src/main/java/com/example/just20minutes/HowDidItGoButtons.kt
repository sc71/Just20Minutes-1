package com.example.just20minutes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import java.util.*
import java.util.concurrent.TimeUnit

class HowDidItGoButtons : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_did_it_go_buttons)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        //set progress bar values here
        val progressBar = findViewById<ProgressBar>(R.id.progressBar_howDidItGo_timer)
        //sets max value for progress bar
        progressBar.max = 2700
        //makes progress bar taller
        progressBar.scaleY = 3F

        //go to RelaxTimer
        val toRelaxTimerButton = findViewById<Button>(R.id.toRelaxTimerButton)
        toRelaxTimerButton.setOnClickListener{
            val intent = Intent(this,RelaxTimer::class.java)
            startActivity(intent)
            finish()
        }

        //buttonTimer got mad at the normal intent stuff so I created a fun for it
        val wentWellButton = findViewById<Button>(R.id.wentWellButton)
        wentWellButton.setOnClickListener{
            wentWell()
        }

        //determines loading bar progress (attempt 2)
        //does everything except show loading bar progress...timer does work because it calls wentWell()
        //shows progress only as horizontal loading bar --> couldn't figure out the other one so you get horizontal

        //adjust times here, but good enough for demo purposes
        val buttonTimer = object: CountDownTimer(300000, 100){
            private var progress = 0

            //updates progress bar
            override fun onTick(millisUntilFinished: Long) {
                progressBar.progress = progress
                progress += 1
            }

            override fun onFinish() {
                wentWell()
            }
        }
        buttonTimer.start()
    }

    //go to ItemScreen
    fun wentWell(){
        val intent = Intent(this,ToDoList::class.java)
        startActivity(intent)
        finish()
    }
}