package com.code.shinobi.notedkmm

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(NotesDatabase.Schema, "notes.db")
    }
}