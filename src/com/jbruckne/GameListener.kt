package com.jbruckne

public interface GameListener {
    fun updateBoard(board: Board)
    fun stalemate()
    fun winner(player: Player)
    fun promptMove(player: Player)
    fun invalidMove(player: Player, count: Int)
    fun loseTurn(player: Player)
    fun help()
}