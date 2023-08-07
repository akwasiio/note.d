//
//  AllNotesScreen.swift
//  iosApp
//
//  Created by Levi Ackerman on 8/5/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI

fileprivate let newNote = Note(id: -1, title: "", content: "", type: NoteType.newNote)
struct AllNotesScreen: View {
    @StateObject var allNotesVM = AllNotesVM()
    
    var body: some View {
        NavigationView {
            StaggeredGrid(list: [newNote] + allNotesVM.notes) { note in
                Group {
                    if note.type == .newNote {
                        NavigationLink(destination: CreateNoteScreen()) {
                            NewNoteComponent()
                        }
                    } else {
                        NavigationLink(destination: EditNoteScreen(id: note.id)) {
                            NoteListItem(title: note.title, content: note.content)
                        }
                    }
                }
            }.padding()
        }
    }
}




struct NoteListItemPreview_Provider: PreviewProvider {
    static var previews: some View {
        NoteListItem(title: "This job hard", content: "Dave and Cench banging loud on the speaker and the vibes are just immaculate. This can't be life")
    }
}


struct StaggeredNotesGridPreview_Provider: PreviewProvider {
    static let notes = [
        Note(id: 0, title: "", content: "", type: NoteType.newNote),
        Note(id: 1, title: "The job hard", content: "The job hard too much"),
        Note(id: 2, title: "The job hard", content: "The job hard too much"),
        Note(id: 3, title: "The job hard", content: "The job hard too much"),
        Note(id: 4, title: "The job hard", content: "The job hard too much"),
        Note(id: 5, title: "The job hard", content: "The job hard too much"),
        Note(id: 6, title: "The job hard", content: "The job hard too much, and sometimes you just taya") ,
        Note(id: 7, title: "The job hard", content: "The job hard too much, and sometimes you just taya"),
        
        Note(id: 8, title: "The job hard", content: "The job hard too much, and sometimes you just taya. ashdhasjdsjhhdergdywqdbhejbhdsbasdhsaihuffhisdehfihfhsddsbhdshjdhjdsahjas"),
        
    ]
    static var previews: some View {
        StaggeredGrid(list: notes) { note in
            Group {
                if note.type == .newNote {
                    NewNoteComponent()
                } else {
                    NoteListItem(title: note.title, content: note.content)
                }
            }
            
        }
    }
}
