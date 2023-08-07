//
//  EditNoteScreen.swift
//  iosApp
//
//  Created by Levi Ackerman on 8/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct EditNoteScreen: View {
    let id: Int64
    @StateObject var editNoteVM = EditNoteVM()
    
    var body: some View {
        NoteEditLayout(title: $editNoteVM.note.title, content: $editNoteVM.note.content) {
            editNoteVM.updateNote(id: editNoteVM.note.id, title: editNoteVM.note.title, content: editNoteVM.note.content)
        }.onAppear {
            editNoteVM.getNoteById(id: id)
        }
    }
}
