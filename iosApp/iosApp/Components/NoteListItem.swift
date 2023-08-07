//
//  NoteListItem.swift
//  iosApp
//
//  Created by Levi Ackerman on 8/6/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct NoteListItem: View {
    let title: String
    let content: String
    
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8.0) {
            Text(title)
                .bold()
                .foregroundStyle(.black)
                .multilineTextAlignment(.leading)
            
            Text(content)
                .frame(maxWidth: .infinity, alignment: .leading)
                .foregroundStyle(.black)
                .lineLimit(7)
                .multilineTextAlignment(.leading)
            
        }.frame(maxWidth: .infinity, alignment: .leading)
            .padding(.all)
            .background(Color(.ghostWhite))
            .overlay {
                RoundedRectangle(cornerRadius: 8)
                    .stroke(Color(.placeholderText), lineWidth: 1)
            }
    }
}

//#Preview {
//    NoteListItem(title: "This job hard", content: "This job hard way too much...")
//}
