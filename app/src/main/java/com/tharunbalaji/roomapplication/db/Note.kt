package com.tharunbalaji.roomapplication.db

import androidx.room.Entity
import androidx.room.PrimaryKey

// Table -> Columns
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "",
    val content: String = ""
)
