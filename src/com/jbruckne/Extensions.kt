package com.jbruckne

public fun Char.alphaIndex(): Int {
    return this.toLowerCase().toInt() - 'a'.toInt()
}

public fun Char.number(): Int {
    return this.toInt() - '0'.toInt()
}

public fun Int.alphaValue(): Char {
    return ('a'.toInt() + this).toChar()
}