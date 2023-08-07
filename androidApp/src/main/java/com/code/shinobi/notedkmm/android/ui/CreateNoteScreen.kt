package com.code.shinobi.notedkmm.android.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.code.shinobi.notedkmm.android.MyApplicationTheme
import com.code.shinobi.notedkmm.android.R
import com.code.shinobi.notedkmm.android.ui.theme.textPlaceholderColor
import comcodeshinobinotedkmmdb.Notes
import org.koin.androidx.compose.koinViewModel


@Composable
fun CreateNoteScreen(viewModel: CreateNoteViewModel = koinViewModel(), goBack: () -> Unit) {
    var titleText by remember { mutableStateOf("") }
    var noteContentText by remember { mutableStateOf("") }

    NoteEditingLayout(
        title = titleText,
        content = noteContentText,
        onTitleChanged = { titleText = it },
        onContentChanged = { noteContentText = it },
        onSaveClick = {
            viewModel.createNote(titleText, noteContentText)
            goBack()
        }
    )
}

@Composable
fun EditNoteScreen(editNoteViewModel: EditNoteViewModel = koinViewModel(), goBack: () -> Unit) {
    val note by editNoteViewModel.note.collectAsState(initial = Notes(0L, "", "", ""))
    var title by remember(note.title) { mutableStateOf(note.title) }
    var content by remember(note.content) { mutableStateOf(note.content) }

    NoteEditingLayout(
        title = title,
        content = content,
        onTitleChanged = { title = it },
        onContentChanged = { content = it },
        onSaveClick = { editNoteViewModel.updateNote(title, content); goBack() }
    )
}

@Composable
private fun NoteEditingLayout(
    title: String,
    content: String,
    onTitleChanged: (String) -> Unit,
    onContentChanged: (String) -> Unit,
    onSaveClick: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            NoteEditTextField(
                text = title,
                onTextChanged = onTitleChanged,
                placeholder = {
                    Text(
                        "Enter title of note...",
                        style = MaterialTheme.typography.h4.copy(
                            fontWeight = FontWeight.W500,
                            color = textPlaceholderColor
                        ),
                    )
                },
                textStyle = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.W500)
            )

            NoteEditTextField(
                text = content,
                onTextChanged = onContentChanged,
                placeholder = {
                    Text(
                        text = stringResource(R.string.notes_content_placeholder_text),
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 18.sp,
                            color = textPlaceholderColor
                        )
                    )
                },
                textStyle = MaterialTheme.typography.h6
            )
        }


        ButtonRow(
            modifier = Modifier.align(Alignment.BottomEnd),
            onSaveClick = onSaveClick,
            onChangeThemeClick = {}
        )
    }
}

@Composable
private fun NoteEditTextField(
    text: String,
    onTextChanged: (String) -> Unit,
    placeholder: @Composable () -> Unit,
    textStyle: TextStyle,
) {
    TextField(
        value = text,
        placeholder = placeholder,
        onValueChange = onTextChanged,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            cursorColor = Color.Black
        ),
        modifier = Modifier.fillMaxWidth(),
        textStyle = textStyle
    )
}

@Composable
private fun ButtonRow(
    modifier: Modifier,
    onSaveClick: () -> Unit,
    onChangeThemeClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(16.dp)
    ) {
        FloatingActionButton(onClick = onChangeThemeClick) {
            Icon(Icons.Default.Save, contentDescription = null)
        }

        FloatingActionButton(onClick = onSaveClick) {
            Icon(Icons.Default.Save, contentDescription = null)
        }

    }
}

@Preview
@Composable
private fun CreateNoteScreenPreview() {
    MyApplicationTheme(darkTheme = false) {
        CreateNoteScreen(goBack = {})
    }
}