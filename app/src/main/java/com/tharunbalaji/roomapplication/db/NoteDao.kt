package com.tharunbalaji.roomapplication.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


// Create, Read, Update, Delete

@Dao
abstract class NoteDao {
    @Insert
    abstract suspend fun create(note: Note)

    @Update
    abstract suspend fun update(note: Note)

    @Query("SELECT * FROM notes ORDER BY id DESC")
    abstract fun readAllNotes(): LiveData<List<Note>>

    @Delete
    abstract suspend fun delete(note: Note)
}

/*
* 1.
* 2.
* 3.
* 4.
* 5. <- latest note
* */