package com.example.just20minutes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToTimerButton = findViewById<Button>(R.id.goToTimerButton)
        goToTimerButton.setOnClickListener{
            val intent = Intent(this,TwentyMinuteTimer::class.java)
            startActivity(intent)
        }

        val toDoButton= findViewById<Button>(R.id.toDoButton)
        toDoButton.setOnClickListener{
            val intent = Intent(this,ToDoList::class.java)
            startActivity(intent)
        }
        //checklist.setOnClickListener --> checklist fragment/intent
    }
}

