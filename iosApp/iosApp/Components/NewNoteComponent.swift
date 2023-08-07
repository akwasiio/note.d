//
//  NewNoteComponent.swift
//  iosApp
//
//  Created by Levi Ackerman on 8/6/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI


struct NewNoteComponent: View {
    var body: some View {
        VStack(alignment: .center, spacing: 8.0) {
            Image(systemName: "plus")
                .foregroundStyle(Color(.lightBlue400))
                .frame(width: 40, height: 40)
                .background(.white)
                .clipShape(Circle())
                .overlay {
                    Circle()
                        .strokeBorder(Color(.lightBlueDashed), style: StrokeStyle(lineWidth: 1, dash: [2, 2]))
                }
            
            
            Text("New note")
                .foregroundStyle(Color(.lightBlue700))
        }.frame(maxWidth: .infinity)
            .frame(height: 170)
            .padding()
            .background(Color(.lightBlue25))
            .overlay {
                RoundedRectangle(cornerRadius: 8)
                    .stroke(Color(.lightBlue200), lineWidth: 1)
            }
    }
}

//#Preview {
//    NewNoteComponent()
//}
