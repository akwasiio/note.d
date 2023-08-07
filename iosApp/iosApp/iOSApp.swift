import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
//        KoinKt.doInitKoin()
        KoinApplication.start()
    }
    
	var body: some Scene {
		WindowGroup {
			AllNotesScreen()
		}
	}
}
