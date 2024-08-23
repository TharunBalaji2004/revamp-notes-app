package com.tharunbalaji.roomapplication.repository

import androidx.lifecycle.LiveData
import com.tharunbalaji.roomapplication.db.Note
import com.tharunbalaji.roomapplication.db.NoteDao

class NoteRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<Note>> = noteDao.readAllNotes()

    suspend fun create(note: Note) {
        noteDao.create(note)
    }

    suspend fun update(note: Note) {
        noteDao.update(note)
    }

    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }
}

// 1 screen -> ViewModel
