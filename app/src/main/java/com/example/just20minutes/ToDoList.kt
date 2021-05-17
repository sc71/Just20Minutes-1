package com.example.just20minutes

import android.content.Intent
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.just20minutes.R

class ToDoList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)
        // Initializing the array lists and the adapter
        var itemlist = arrayListOf<ToDoItem>()

        var adapter = CustomArrayAdapter(this, itemlist)

        // Adding the items to the list when the add button is pressed
        val add = findViewById<Button>(R.id.add)
        val delete = findViewById<Button>(R.id.delete)
        val clear = findViewById<Button>(R.id.clear)
        val editText = findViewById<EditText>(R.id.editText)
        val listView = findViewById<ListView>(R.id.listView)

        listView.adapter = adapter

        //time for shared preferences
        

        add.setOnClickListener {
            var item = ToDoItem(editText.text.toString(), false)
            itemlist.add(item)
            adapter.notifyDataSetChanged()
            // This is because every time when you add the item the input space or the eidt text space will be cleared
            editText.text.clear()
        }
        // Clearing all the items in the list when the clear button is pressed
        clear.setOnClickListener {

            itemlist.clear()
            adapter.notifyDataSetChanged()
        }
        // Adding the toast message to the list when an item on the list is pressed
        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "You Selected the item --> " + itemlist.get(position), Toast.LENGTH_SHORT).show()
            
        }
        // Selecting and Deleting the items from the list when the delete button is pressed
        delete.setOnClickListener {
            for (i in itemlist.size-1 downTo 0) {
                if(itemlist[i].checkBox){
                    adapter.remove(itemlist[i])
                }
            }
            adapter.notifyDataSetChanged()
        //    val position: SparseBooleanArray = listView.checkedItemPositions
//            val count = listView.count
//            var item = count - 1
//            while (item >= 0) {
//                if (position.get(item)) {
//                    adapter.remove(itemlist.get(item))
//                }
//                item--
//            }
//            position.clear()
//            adapter.notifyDataSetChanged()
//            for (i in itemlist.size()-1 downTo 0 )
//            {
//                if(itemlist.get(i).)
//            }
        }
    }
}