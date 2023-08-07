package com.code.shinobi.notedkmm.di

import com.code.shinobi.notedkmm.repositories.NotesRepository
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

expect fun platformModule(): Module

fun initKoin(appDeclaration: KoinAppDeclaration = {}): KoinApplication {
    return startKoin {
        appDeclaration()
        modules(platformModule(), commonModule())
    }
}

fun initKoin() = initKoin {  }

fun KoinApplication.Companion.start(): KoinApplication = initKoin {}

fun commonModule(): Module = module {
    single { NotesRepository() }
}

val Koin.notesRepository: NotesRepository
    get() = get()