//
//  Note.swift
//  iosApp
//
//  Created by Levi Ackerman on 8/5/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

enum NoteType {
    case newNote, listItem
}

struct Note: Identifiable, Hashable {
    let id: Int64
    var title: String
    var content: String
    var type: NoteType = .listItem
}
