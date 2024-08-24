package com.tharunbalaji.roomapplication.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tharunbalaji.roomapplication.db.Note
import com.tharunbalaji.roomapplication.db.NoteDatabase
import com.tharunbalaji.roomapplication.repository.NoteRepository
import kotlinx.coroutines.launch

// Context -> Application, Activity, Fragment
// MVVM -> Mode -> Repo -> ViewModel (Business logic) -> Activity (UI)

class NoteViewModel(application: Application): AndroidViewModel(application) {

    private val repository: NoteRepository
    val allNotes: LiveData<List<Note>>

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao() // NoteDao initialization
        repository = NoteRepository(noteDao)
        allNotes = repository.allNotes
    }

    // Coroutine usage
    fun create(note: Note) = viewModelScope.launch {
        repository.create(note)
    }

    fun update(note: Note) = viewModelScope.launch {
        repository.update(note)
    }

    fun delete(note: Note) = viewModelScope.launch {
        repository.delete(note)
    }
}