package com.bignerdranch.nyethack

import java.lang.Exception

fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }

    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
        println("You juggle $swordsJuggling swords!")
    } catch (k: Exception) {
        println(k)
    }
}

fun proficiencyCheck(swordsJuggling: Int?) {
    checkNotNull(swordsJuggling, { "com.bignerdranch.nyethack.Player cannot juggle swords" })
}

class UnskilledSwordJugglerException :
    IllegalStateException("com.bignerdranch.nyethack.Player cannot juggle swords")