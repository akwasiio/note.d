package com.code.shinobi.notedkmm

import app.cash.sqldelight.db.SqlDriver

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DriverFactory): NotesDatabase {
    val driver = driverFactory.createDriver()

    return NotesDatabase(driver)
}