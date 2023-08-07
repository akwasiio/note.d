//
//  NoteEditLayout.swift
//  iosApp
//
//  Created by Levi Ackerman on 8/6/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct NoteEditLayout: View {
    @Binding var title: String
    @Binding var content: String
    
    var onSaveTap: () -> Void
    @Environment(\.dismiss) var dismiss
    
    var body: some View {
        VStack(alignment: .trailing) {
            
            VStack(alignment: .leading) {
                MultiLineTextField(
                    text: $title,
                    placeholderText: "Enter title of note...",
                    font: .largeTitle,
                    foregroundColor: Color(
                        .notedTextPlaceholder
                    )
                ).padding(.horizontal)
                
                MultiLineTextField(
                    text: $content,
                    placeholderText: "This is where your note will be. It’ll be housed here. You’ll save your note here. Type your memories here. Write down your thoughts.",
                    font: .body,
                    foregroundColor: Color(
                        .notedTextPlaceholder
                    )
                ).padding(.horizontal)
        
            }
            
            Spacer()
            
            
            VStack {
                Image(.save)
                    .resizable()
                    .frame(width: 32, height: 32)
                    .foregroundStyle(.blue)
            }.frame(alignment: .bottomTrailing)
                .padding(20)
                .background(.red)
                .clipShape(Circle())
                .padding(.horizontal)
                .onTapGesture {
                    onSaveTap()
                    dismiss()
                }
        }
    }
}

struct MultiLineTextField: View {
    @Binding var text: String
    let placeholderText: String
    let font: Font
    let foregroundColor: Color
    
    
    var body: some View {
        ZStack(alignment: .topLeading) {
            if text.isEmpty {
                Text(placeholderText)
                    .font(font)
                    .padding(.leading, 3)
                    .foregroundColor(foregroundColor)
                    .disabled(true)
                    .multilineTextAlignment(.leading)
            }
            
            TextEditor(text: $text)
                .textFieldStyle(.plain)
                .font(font)
                .opacity(text.isEmpty ? 0.25 : 1)
                .frame(minHeight: 44.0, alignment: .topLeading)
                .fixedSize(horizontal: false, vertical: true)
                .tint(.black)
            
        }
    }
}
