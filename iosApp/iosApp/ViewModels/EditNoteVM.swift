//
//  EditNoteVM.swift
//  iosApp
//
//  Created by Levi Ackerman on 8/6/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import KMPNativeCoroutinesAsync

class EditNoteVM: ObservableObject {
    @LazyKoin var notesRepository: NotesRepository
    
    @Published var note: Note = Note(id: 0, title: "", content: "")
    
    
    func getNoteById(id: Int64) {
        let result = notesRepository.getNoteById(id: id)
        note = Note(id: result.id, title: result.title, content: result.content)
    }
    
    func updateNote(id: Int64, title: String, content: String) {
        notesRepository.updateNote(id: id, title: title, content: content)
    }
}
