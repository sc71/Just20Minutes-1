package com.example.just20minutes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ToDoList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)

        /*https://github.com/mukeshsolanki/easypreferences
        helpful link from mr shorr about storing items so the to do list doesn't go poof when you close the app*/

        //I think we can use a floating action button to dynamically add items (checkboxes) to the list
    }
}