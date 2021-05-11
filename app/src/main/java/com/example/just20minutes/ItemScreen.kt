package com.example.just20minutes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ItemScreen : AppCompatActivity() {
    companion object{
        val EXTRA_TODO_ITEM = "oh yeah bear"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_screen)

        val toDo = intent.getParcelableExtra<ToDoItem>(EXTRA_TODO_ITEM)
    }
}