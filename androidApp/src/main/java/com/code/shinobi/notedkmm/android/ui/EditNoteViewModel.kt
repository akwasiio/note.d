package com.code.shinobi.notedkmm.android.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.code.shinobi.notedkmm.repositories.NotesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class EditNoteViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val notesRepo: NotesRepository
) : ViewModel() {

    @OptIn(ExperimentalCoroutinesApi::class)
    val note = savedStateHandle.getStateFlow("note-id", -1L).flatMapLatest {
        flowOf(notesRepo.getNoteById(it))
    }


    fun updateNote(title: String, content: String) {
        viewModelScope.launch {
            val id = note.first().id
            notesRepo.updateNote(id, title, content)
        }
    }
}