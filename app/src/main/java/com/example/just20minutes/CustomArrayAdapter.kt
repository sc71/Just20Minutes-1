package com.example.just20minutes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView

class CustomArrayAdapter(context:Context, toDoItems:ArrayList<ToDoItem>): ArrayAdapter<ToDoItem>(context, 0, toDoItems) {
     override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get the data item for this position
        val toDoItem = getItem(position)
        // Check if an existing view is being reused, otherwise inflate the view

           val rowView = LayoutInflater.from(getContext()).inflate(R.layout.itemlist, parent, false)

        // Lookup view for data population
        val name = rowView.findViewById(R.id.itemTitle) as TextView
        val check = rowView.findViewById(R.id.checkBox) as CheckBox
        // Populate the data into the template view using the data object
         name.text = toDoItem?.name
        check.isChecked= toDoItem?.checkBox?:false
         name.setOnClickListener{
             //takes you to item page
         }
         check.setOnClickListener{

         }
        // Return the completed view to render on screen
        return rowView
    }
}