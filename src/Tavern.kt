import kotlin.math.roundToInt
import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"

val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-data.txt")
    .readText()
    .split("\n")
val patronGold = mutableMapOf<String, Double>()



fun main(args: Array<String>) {

    toReadableMenu()


    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }

    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master says: Nay, they departed hours ago.")
    }

//    placeOrder("shandy,Dragon's Breath,5.91")


    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }

    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(),
            menuList.shuffled().first())
        orderCount++
    }

    displayPatronBalances()



}

fun performPurchase(price: Double,patronName: String) {
    val totalPupse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPupse - price
}


private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")
    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price."

    println(message)
    performPurchase(price.toDouble(), patronName)

    //performPurchase(price.toDoubleOrNull() ?: 0.0)

    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims ${toDragonSpeak("DRAGON'S BREATH: IT'S GOT WHAT ADVENTURERS CRAVE! $name!")}"
    } else {
        "$patronName says: Thanks for the $name."
    }
    println(phrase)
}

private fun toReadableMenu() {
    val menuList = File("data/tavern-menu-data.txt")
        .readText()
        .split("\n")
        .toList()

    val greetings = "***Welcome to $TAVERN_NAME***"
    println(greetings)
    menuList.forEach{ menuPosition ->
        val (type, name, price) = menuPosition.split(",")
        val nameSize = name.count()
        val priceSize = price.count()
        val greetingsSize = greetings.count()
        val dotsSize = greetingsSize - (nameSize + priceSize)
        val dots: String = ".".repeat(dotsSize)
        println(String.format("%s%s%s", name.capitalize(), dots, price))
    }

}

private fun toDragonSpeak(phrase: String) = phrase.replace(Regex("[aeiouAEIOU]")) {
    when (it.value) {
        "a", "A" -> "4"
        "e", "E" -> "3"
        "i", "I" -> "1"
        "o", "O" -> "0"
        "u", "U" -> "|_|"
        else -> it.value
    }

}

private fun displayPatronBalances() {
    patronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}
