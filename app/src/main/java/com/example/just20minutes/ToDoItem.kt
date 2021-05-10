package com.example.just20minutes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ToDoItem(var name: String, var checkBox: Boolean) : Parcelable {
}