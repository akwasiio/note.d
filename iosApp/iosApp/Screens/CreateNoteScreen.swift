//
//  CreateNoteScreen.swift
//  iosApp
//
//  Created by Levi Ackerman on 8/6/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CreateNoteScreen: View {
    
    @State var title: String = ""
    @State var content: String = ""
    
    @StateObject var vm = CreateNoteVM()
    
    var body: some View {
        NoteEditLayout(title: $title, content: $content) {
            vm.createNote(title: title, content: content)
        }
    }
}


struct CreateNoteScreenPreview_Provider: PreviewProvider {
    static var previews: some View {
        CreateNoteScreen()
    }
}
