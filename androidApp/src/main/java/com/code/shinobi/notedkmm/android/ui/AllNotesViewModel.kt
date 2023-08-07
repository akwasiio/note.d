package com.code.shinobi.notedkmm.android.ui

import androidx.lifecycle.ViewModel
import com.code.shinobi.notedkmm.repositories.NotesRepository

class AllNotesViewModel(private val repo: NotesRepository) : ViewModel() {
    val notes = repo.getNotes()
}