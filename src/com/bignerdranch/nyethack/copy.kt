package com.bignerdranch.nyethack

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 1
    val isBlessed = true
    val isImmortal = false


    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) *
            20).toInt()

    val carmaColour = when (karma) {
        in 0..5 -> "red"
        in 6..10 -> "orange"
        in 11..15 -> "purpure"
        in 16..20 -> "green"
        else -> "none"
    }


    // Аура
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    //Состояние игрока
    printPlayerStatus(auraColor, isBlessed, carmaColour, name, healthStatus)

    castFireball(29)

}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    carmaColour: String,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor) " +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})" +
                "(Carma colour: $carmaColour)"
    )
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =

    if (isBlessed && healthPoints > 50 || isImmortal) {
        "GREEN"
    } else {
        "NONE"
    }


private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }


private fun castFireball(numFireballs: Int = 2) {


    val howAreYou = when (numFireballs) {
        in 1..10 -> "Tipsy"
        in 11..20 -> "Sloshed"
        in 21..30 -> "Soused"
        in 31..40 -> "Stewed"
        in 41..50 ->"..t0aSt3d"
        else -> "None"
    }
    println("A $numFireballs glass of Fireball springs into existence. You are $howAreYou")
}