package com.jbruckne

public data class GameState(val board: Board) {

    public fun stalemate() = board.filled()

    public fun complete(): Boolean {
        if (checkRightDiagonal(board) || checkLeftDiagonal(board)) return true
        for (i in 0..board.size-1) if (checkColumn(board, i)) return true
        for (i in 0..board.size-1) if (checkRow(board, i)) return true
        return false
    }

    private fun checkRightDiagonal(board: Board): Boolean {
        for (i in 0..board.size-2)
            if (board[i,i] == Player.NONE || board[i, i] != board[i + 1, i + 1]) return false
        return true
    }

    private fun checkLeftDiagonal(board: Board): Boolean {
        for (i in board.size-1 downTo 1)
            if (board[i, i] == Player.NONE || board[i, i] != board[i - 1, i - 1]) return false
        return true
    }

    private fun checkRow(board: Board, row: Int): Boolean {
        for (i in 0..board.size-2)
            if (board[row,i] == Player.NONE || board[row, i] != board[row, i + 1]) return false
        return true
    }

    private fun checkColumn(board: Board, column: Int): Boolean {
        for (i in 0..board.size-2)
            if (board[i,column] == Player.NONE || board[i, column] != board[i + 1, column]) return false
        return true
    }
}