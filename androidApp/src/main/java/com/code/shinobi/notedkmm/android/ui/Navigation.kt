package com.code.shinobi.notedkmm.android.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


object Routes {
    val viewAllNotes = "/view-all-notes"
    val createNote = "/create-note"
    val editNote = "/edit-note"
    val editNoteFullRoute = "$editNote/{note-id}"
}

fun NavGraphBuilder.allNotesScreen(navHostController: NavHostController) {
    composable(Routes.viewAllNotes) {
        AllNotesScreen(
            onNewNoteClick = { navHostController.navigate(Routes.createNote) },
            onItemClick = { navHostController.navigateToEditNoteScreen(it) },
        )
    }
}

fun NavGraphBuilder.createNoteScreen(navHostController: NavHostController) {
    composable(Routes.createNote) {
        CreateNoteScreen(goBack = navHostController::navigateUp)
    }
}

fun NavGraphBuilder.editNoteScreen(navHostController: NavHostController) {
    composable(
        Routes.editNoteFullRoute,
        arguments = listOf(navArgument("note-id") { type = NavType.LongType })
    ) {
        EditNoteScreen() {
            navHostController.navigateUp()
        }
    }
}

fun NavHostController.navigateToEditNoteScreen(noteId: Long) {
    navigate(Routes.editNote + "/${noteId}")
}