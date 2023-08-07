package com.code.shinobi.notedkmm.di

import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.code.shinobi.notedkmm.DriverFactory
import com.code.shinobi.notedkmm.NotesDatabase
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
        val driver = NativeSqliteDriver(NotesDatabase.Schema, "notes.db")
        NotesDatabase(driver)
    }
}