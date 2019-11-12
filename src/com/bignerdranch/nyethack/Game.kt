package com.bignerdranch.nyethack

fun main(args: Array<String>) {

    val player = Player(name = "Madrigal")


    // Аура
    val auraColor = player.auraColor()

    //Состояние игрока
    printPlayerStatus(player)

    player.auraColor()

    player.castFireball()

}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) " +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}






