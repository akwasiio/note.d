//
//  AllNotesVM.swift
//  iosApp
//
//  Created by Levi Ackerman on 8/6/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import KMPNativeCoroutinesAsync



@MainActor
class AllNotesVM: ObservableObject {
    @LazyKoin var notesRepository: NotesRepository
    
    @Published var notes: [Note] = []
    
    init() {
//        self.notesRepository = notesRepo
        getNotes()
    }
    
    
    func getNotes(){
        Task {
            do {
                let results = asyncSequence(for: notesRepository.getNotes())
                
                for try await dbNotes in results {
                    notes = dbNotes.compactMap { item in
                        Note(id: item.id, title: item.title, content: item.content)
                    }
                }
            } catch {
                print("Failed with error: \(error)")
            }
        }
        
    }
}
