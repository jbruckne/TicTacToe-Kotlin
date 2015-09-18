package com.jbruckne

import java.util.*
import java.util.regex.Pattern

public data class Game(val boardSize: Int = 3,
                  val maxInvalid: Int = 5,
                  val listener: GameListener = SimpleGameListener()) {

    val board = Board(boardSize)
    var player = Player.ONE
    var isActive = true
    var invalidCount = 0

    init {
        listener.updateBoard(board)
        listener.promptMove(player)
    }

    public fun advance(row: Int, column: Int) {
        if (!validMove(row, column)) {
            penalize()
            return
        }
        board[row, column] = player
        val state = GameState(board)
        if (state.complete()) {
            isActive = false
            listener.winner(player)
            return
        } else if (state.stalemate()) {
            isActive = false
            listener.stalemate()
            return
        }
        switchPlayers()
    }

    private fun validMove(row: Int, column: Int): Boolean {
        if (board.valid(row, column)) {
            invalidCount = 0
            return true
        }
        return false
    }

    private fun penalize() {
        if (++invalidCount > maxInvalid && maxInvalid != -1) {
            listener.loseTurn(player)
            switchPlayers()
        } else {
            listener.invalidMove(player, invalidCount)
            listener.promptMove(player)
        }
    }

    private fun switchPlayers() {
        player = !player
        invalidCount = 0
        listener.updateBoard(board)
        listener.promptMove(player)
    }
}