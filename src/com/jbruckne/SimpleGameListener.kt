package com.jbruckne

public class SimpleGameListener: GameListener {

    override fun updateBoard(board: Board) {
        System.out.println(board.toString())
    }

    override fun stalemate() {
        System.out.println("Stalemate...")
    }

    override fun winner(player: Player) {
        System.out.println("\n\nWooohoooooo")
        System.out.println("Player $player wins!!!! ")
        System.out.println("You rock!!!\n\n")
    }

    override fun promptMove(player: Player) {
        System.out.print("Player $player, enter move: ")
    }

    override fun invalidMove(player: Player, count: Int) {
        when (count) {
            0, 1 -> System.out.println("Invalid move")
            else -> System.out.println("Invalid move. Enter 'help' for instructions.")
        }
    }

    override fun loseTurn(player: Player) {
        System.out.println("Look over rules while other player takes their move.")
    }

    override fun help() {
        throw UnsupportedOperationException()
    }

}