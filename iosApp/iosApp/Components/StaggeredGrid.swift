//
//  StaggeredGrid.swift
//  iosApp
//
//  Created by Levi Ackerman on 8/5/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct StaggeredGrid<Content: View, T: Identifiable>: View where T: Hashable {
    var list: [T]
    var content: (T) -> Content
    
    init(list: [T], content: @escaping (T) -> Content) {
        self.list = list
        self.content = content
    }
    
    
    func setupList() -> [[T]] {
        var gridArray: [[T]] = Array(repeating: [], count: 2)
        var currentIndex = 0
        
        for item in list {
            gridArray[currentIndex].append(item)
            
            if currentIndex == 1 {
                currentIndex = 0
            } else {
                currentIndex += 1
            }
        }
        
        return gridArray
    }
    
    var body: some View {
        ScrollView(.vertical, showsIndicators: false) {
            HStack(alignment: .top) {
                ForEach(setupList(), id: \.self) { data in
                    LazyVStack(spacing: 8) {
                        ForEach(data) { item in
                            content(item)
                        }
                    }
                }
            }.padding()
        }
    }
}
