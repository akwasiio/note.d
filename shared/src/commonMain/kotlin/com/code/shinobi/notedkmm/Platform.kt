package com.code.shinobi.notedkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform