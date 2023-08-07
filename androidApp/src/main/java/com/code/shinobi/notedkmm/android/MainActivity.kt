package com.code.shinobi.notedkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.code.shinobi.notedkmm.android.ui.AllNotesScreen
import com.code.shinobi.notedkmm.android.ui.CreateNoteScreen
import com.code.shinobi.notedkmm.android.ui.Routes
import com.code.shinobi.notedkmm.android.ui.allNotesScreen
import com.code.shinobi.notedkmm.android.ui.createNoteScreen
import com.code.shinobi.notedkmm.android.ui.editNoteScreen
import com.code.shinobi.notedkmm.repositories.NotesRepository
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    val repo: NotesRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApplicationTheme() {
                        Scaffold() { paddingValues ->
                            NavHost(
                                navController = navController,
                                startDestination = Routes.viewAllNotes,
                                modifier = Modifier.padding(paddingValues)
                            ) {
                                allNotesScreen(navController)
                                createNoteScreen(navController)
                                editNoteScreen(navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
