package com.jbruckne

public enum class Player(val mark: String) {
    NONE(" "),
    ONE("X"),
    TWO("O");

    public fun not(): Player {
        if (this == ONE) return Player.TWO
        return Player.ONE
    }

    override fun toString(): String {
        when (this) {
            NONE -> return "GOD"
            ONE -> return "1"
            TWO -> return "2"
        }
    }
}