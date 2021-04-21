package com.example.just20minutes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import java.util.*
import java.util.concurrent.TimeUnit

class TwentyMinuteTimer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twenty_minute_timer)

        val allGoodButton = findViewById<Button>(R.id.allGoodButton)
        allGoodButton.isVisible = false
        val needBreakButton = findViewById<Button>(R.id.needBreakButton)
        needBreakButton.isVisible = false

        var textView = findViewById<TextView>(R.id.text_view)
        val duration = TimeUnit.MINUTES.toMillis(1)
        val durationTwo = TimeUnit.MINUTES.toMillis(1)
        var veinte = object : CountDownTimer(duration, 1000)
        {
            override fun onTick(l: Long){
                var sDuration = String.format(Locale.ENGLISH, "%02d : %02d",
                        TimeUnit.MILLISECONDS.toMinutes(l),TimeUnit.MILLISECONDS.toSeconds(l) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)))
                textView.text = sDuration
            }

            override fun onFinish() {
                textView.isVisible = false
                allGoodButton.isVisible = true
                needBreakButton.isVisible = true
                allGoodButton.setOnClickListener{
                    //takes you to the item page

                    //maybe we can use a progress bar for this and set an onClickListener to that?
                    //Widgets > ProgressBar
                }
                needBreakButton.setOnClickListener{
                    //takes you to the help timer page
                }

                //if you want to add a new timer maybe make a new function and put this code there.
                /*var cinco = object : CountDownTimer(durationTwo, 1000)
                {
                    //could make override fun onTick that makes it so the timer shows, not needed
                    override fun onFinish() {
                        //takes you to the item page
                    }
                }*/
            }
        }

        val startTimerButton = findViewById<Button>(R.id.startTimerButton)
        startTimerButton.isVisible = true
        startTimerButton.setOnClickListener {
            veinte.start()
            startTimerButton.isVisible = false
        }

        //setOnClickListener for both buttons --> move to new intent/fragment
    }
}