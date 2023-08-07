package com.code.shinobi.notedkmm.android

import android.app.Application
import com.code.shinobi.notedkmm.android.ui.AllNotesViewModel
import com.code.shinobi.notedkmm.android.ui.CreateNoteViewModel
import com.code.shinobi.notedkmm.android.ui.EditNoteViewModel
import com.code.shinobi.notedkmm.di.initKoin
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.logger.Level
import org.koin.dsl.koinApplication
import org.koin.dsl.module

class NotedApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Napier.base(DebugAntilog())
        initKoin {
            androidContext(this@NotedApplication)
            modules(androidModule)
        }
    }

    val androidModule = module {
        viewModel { CreateNoteViewModel(get()) }
        viewModel { AllNotesViewModel(get()) }
        viewModel { EditNoteViewModel(get(), get()) }
    }
}