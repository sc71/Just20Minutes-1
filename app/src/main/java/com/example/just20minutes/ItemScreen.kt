package com.example.just20minutes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ItemScreen : AppCompatActivity() {
    companion object{
        val EXTRA_TODO_ITEM = "oh yeah bear"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_screen)

        val toDo = intent.getParcelableExtra<ToDoItem>(EXTRA_TODO_ITEM)

        val name = toDo?.name

        var textView = findViewById<TextView>(R.id.itemName)
        textView.text = name

        val finishedWithTaskButton = findViewById<Button>(R.id.finishedTaskButton)
        finishedWithTaskButton.setOnClickListener{
            val intent = Intent(this,ToDoList::class.java)
            startActivity(intent)
            finish()
        }
        val needHelpButton = findViewById<Button>(R.id.needHelpButton)
        needHelpButton.setOnClickListener{
            val intent = Intent(this,TwentyMinuteTimer::class.java)
            startActivity(intent)
            finish()
        }
    }
}