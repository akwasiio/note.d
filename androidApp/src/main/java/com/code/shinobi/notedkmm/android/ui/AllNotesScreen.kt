package com.code.shinobi.notedkmm.android.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.code.shinobi.notedkmm.android.ui.theme.ghostWhite
import com.code.shinobi.notedkmm.android.ui.theme.lightBlue200
import com.code.shinobi.notedkmm.android.ui.theme.lightBlue25
import com.code.shinobi.notedkmm.android.ui.theme.lightBlue400
import com.code.shinobi.notedkmm.android.ui.theme.lightBlue700
import com.code.shinobi.notedkmm.android.ui.theme.lightBlueDashed
import com.code.shinobi.notedkmm.android.ui.theme.slateGray
import com.code.shinobi.notedkmm.android.ui.theme.textPlaceholderColor
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AllNotesScreen(
    allNotesViewModel: AllNotesViewModel = koinViewModel(),
    onNewNoteClick: () -> Unit,
    onItemClick: (id: Long) -> Unit
) {
    val notes by allNotesViewModel.notes.collectAsState(initial = emptyList())

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalItemSpacing = 10.dp,
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            NewNoteComponent(onNewNoteClicked = onNewNoteClick)
        }

        items(notes) { note ->
            NoteListItem(
                title = note.title,
                content = note.content,
                onItemClick = { onItemClick(note.id) }
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun NewNoteComponent(onNewNoteClicked: () -> Unit) {
    val stroke =
        Stroke(width = 2f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f))
    Card(
        modifier = Modifier
            .height(170.dp)
            .border(width = 1.dp, color = lightBlue200, shape = RoundedCornerShape(8.dp)),
        onClick = onNewNoteClicked,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = lightBlue25,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .drawBehind {
                        drawRoundRect(
                            lightBlueDashed,
                            style = stroke,
                            cornerRadius = CornerRadius(20.dp.toPx())
                        )
                    }) {
                Icon(Icons.Default.Add, contentDescription = null, tint = lightBlue400)
            }

            Text(
                text = "New note",
                style = MaterialTheme.typography.body1.copy(color = lightBlue700)
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun NoteListItem(title: String, content: String, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier.border(
            width = 1.dp,
            color = textPlaceholderColor,
            shape = RoundedCornerShape(8.dp),
        ),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = ghostWhite,
        onClick = onItemClick
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 18.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.Black
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = content,
                style = MaterialTheme.typography.body2.copy(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight.W500,
                    color = slateGray
                ),
                maxLines = 7,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}