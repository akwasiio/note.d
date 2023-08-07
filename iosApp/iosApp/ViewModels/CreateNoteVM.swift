//
//  CreateNoteVM.swift
//  iosApp
//
//  Created by Levi Ackerman on 8/6/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
class CreateNoteVM: ObservableObject {
    @LazyKoin var repository: NotesRepository

    func createNote(title: String, content: String) {
        Task {
            repository.addNote(title: title, content: content)
        }
    }
}
