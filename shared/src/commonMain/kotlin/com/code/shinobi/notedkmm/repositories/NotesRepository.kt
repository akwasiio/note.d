package com.code.shinobi.notedkmm.repositories

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOne
import com.code.shinobi.notedkmm.NotesDatabase
import com.rickclephas.kmp.nativecoroutines.NativeCoroutineScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import comcodeshinobinotedkmmdb.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NotesRepository : KoinComponent{
    @NativeCoroutineScope
    val mainScope = MainScope()

    val db: NotesDatabase by inject()
    private val queries = db.notedQueries

    @NativeCoroutines
    fun addNote(title: String, content: String) {
        queries.insert(null, title = title, content = content, featured_photo = "")
    }

    @NativeCoroutines
    fun getNotes(): Flow<List<Notes>> {
       return queries.getAllNotes().asFlow().mapToList(Dispatchers.IO)
    }

    fun getNoteById(id: Long): Notes {
        return queries.getNoteById(id).executeAsOne()
    }

    @NativeCoroutines
    fun updateNote(id: Long, title: String, content: String) {
        queries.updateNoteById(title, content, id)
    }
}