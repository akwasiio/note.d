package com.code.shinobi.notedkmm.android.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.code.shinobi.notedkmm.repositories.NotesRepository
import comcodeshinobinotedkmmdb.Notes
import kotlinx.coroutines.launch

class CreateNoteViewModel(private val notesRepository: NotesRepository) : ViewModel() {
    fun createNote(title: String, content: String) {
        viewModelScope.launch {
            notesRepository.addNote(title, content)
        }
    }
}