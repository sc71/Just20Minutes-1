package com.example.just20minutes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//WE SHOULD FIND A WAY TO FINISH() ON ITEM NAME CLICKED

class ToDoList : AppCompatActivity() {
    companion object{
        val PREFS_TODO_LIST = "todo prefs"
        val PREFS_TODO_ITEM = "item prefs"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)
        // Initializing the array lists and the adapter
        var itemlist = readingTodos()

        var adapter = CustomArrayAdapter(this, itemlist)

        // Adding the items to the list when the add button is pressed
        val add = findViewById<Button>(R.id.add)
        val delete = findViewById<Button>(R.id.delete)
        val clear = findViewById<Button>(R.id.clear)
        val editText = findViewById<EditText>(R.id.editText)
        val listView = findViewById<ListView>(R.id.listView)

        listView.adapter = adapter


        add.setOnClickListener {
            var item = ToDoItem(editText.text.toString(), false)
            itemlist.add(item)
            adapter.notifyDataSetChanged()
            // This is because every time when you add the item the input space or the eidt text space will be cleared
            editText.text.clear()
            savingTodos(itemlist)
        }
        // Clearing all the items in the list when the clear button is pressed
        clear.setOnClickListener {

            itemlist.clear()
            adapter.notifyDataSetChanged()
            savingTodos(itemlist)
            val intent = Intent(this,FinishedQuestion::class.java)
            startActivity(intent)
            finish()
            //WE SHOULD MAKE IT NOT CLEAR EVERYTHING UNTIL AFTER THE FINISHED QUESTION IS ANSWERED
            //OR WE COULD MAKE IT ASK IF YOU'RE SURE
        }

        // Selecting and Deleting the items from the list when the delete button is pressed
        delete.setOnClickListener {
            for (i in itemlist.size-1 downTo 0) {
                if(itemlist[i].checkBox){
                    adapter.remove(itemlist[i])
                }
            }
            adapter.notifyDataSetChanged()
            savingTodos(itemlist)
        }
    }
    fun savingTodos(itemlist:ArrayList<ToDoItem>){
        val todoForLater = getPreferences(MODE_PRIVATE)

        val arrayListTodoType = object : TypeToken<ArrayList<ToDoItem>>() {}.type

        val prefsEditor = todoForLater.edit()
        val gson = Gson()
        val json = gson.toJson(itemlist, arrayListTodoType)
        prefsEditor.putString(PREFS_TODO_LIST, json)
        prefsEditor.commit();
    }
    fun readingTodos() : ArrayList<ToDoItem>{
        val todoForLater = getPreferences(MODE_PRIVATE)
        val arrayListTodoType = object : TypeToken<ArrayList<ToDoItem>>() {}.type
        val defaultValue = "[]"
        val jsonString = todoForLater.getString(PREFS_TODO_LIST, defaultValue)
        val gson = Gson()
        var eatenTodoList: ArrayList<ToDoItem> = gson.fromJson(jsonString, arrayListTodoType)
        return eatenTodoList
    }
}