package com.example.just20minutes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ToDoList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)

        val goToFinish = findViewById<Button>(R.id.finishButton)
        goToFinish.setOnClickListener{
            val intent = Intent(this,FinishedQuestion::class.java)
            startActivity(intent)
        }
//        val goToAdditionScreen = findViewById<Button>(R.id.addItemButton)
//        goToAdditionScreen.setOnClickListener{
//            val intent = Intent(this, SOMETHING GOES HERE!!!!!::class.java)
//            startActivity(intent)
//        }
    }
}