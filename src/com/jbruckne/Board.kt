package com.jbruckne

public data class Board(val size: Int = 3) {
    val spaces = Array(size * size, { Player.NONE } )

    public fun get(row: Int, column: Int) = spaces[size*row+column]

    public fun set(row: Int, column: Int, player: Player) {
        spaces[size*row+column] = player
    }

    public fun valid(row: Int, column: Int) = row < size && column < size && this[row, column] == Player.NONE

    public fun filled() = !spaces.contains(Player.NONE)

    override fun toString(): String {
        val builder = StringBuilder()

        builder.append("  ")
        for (column in 0..size-1) builder.append(" ${ column.alphaValue() } ")
        builder.appendln()
        for (row in 0..size-1) {
            addRow(builder, row)
            if (row != size-1) addBreak(builder)
        }

        return builder.toString()
    }

    private fun addRow(builder: StringBuilder, row: Int) {
        builder.append("${ row + 1 }  ${ this[row, 0].mark } ")
        for (column in 1..size-1)
            builder.append("| ${ this[row, column].mark } ")
        builder.appendln()
    }

    private fun addBreak(builder: StringBuilder) {
        builder.append("  ---")
        for (column in 1..size-1)
            builder.append("|---")
        builder.appendln()
    }
}