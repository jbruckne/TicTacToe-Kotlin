package com.jbruckne

import java.util.*
import java.util.regex.Pattern

fun main(args: Array<String>) {
    do (showMenu()) while(run())
}

private fun showMenu() {
    System.out.println()
    System.out.println("1. Play Classic Mode")
    System.out.println("2. Play Custom Mode")
    System.out.println("3. Quit\n")
    System.out.print("Choose option: ")
}

private fun run(): Boolean {
    val input = Scanner(System.`in`)
    val option = input.next().toLowerCase()

    when (option) {
        "1", "classic", "play classic mode" -> {
            val game = Game()
            while (game.isActive) move(game)
        }
        "2", "custom", "play custom mode" -> {
            System.out.print("Enter size of board: ")
            val boardSize = input.nextInt()
            System.out.print("\nEnter max invalid moves: ")
            val maxInvalid = input.nextInt()
            val game = Game(boardSize, maxInvalid)
            while (game.isActive) move(game)
        }
        "3", "quit" -> return false
        else -> System.out.println("Invalid option")
    }
    return true
}

private fun move(game: Game) {
    val input = Scanner(System.`in`)
    val pattern = "[1-9][a-zA-Z]"
    val move = input.next()

    if (Pattern.matches(pattern, move)) {
        val row = move.charAt(0).number() - 1
        val column = move.charAt(1).alphaIndex()
        game.advance(row, column)
    }
}
