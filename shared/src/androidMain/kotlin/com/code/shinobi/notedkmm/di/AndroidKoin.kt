package com.code.shinobi.notedkmm.di

import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.code.shinobi.notedkmm.DriverFactory
import com.code.shinobi.notedkmm.NotesDatabase
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
       val driver = AndroidSqliteDriver(NotesDatabase.Schema, get(), "notes.db")
        NotesDatabase(driver)
    }
}