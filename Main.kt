package machine

var waterSupply = 400
var milkSupply = 540
var coffeeSupply = 120
var cupSupply = 9
var moneySupply = 550

fun main() {
    val stop = 0
    while (stop == 0) {
        println("Write action (buy, fill, take, remaining, exit):")
        val action = readln()
        println()
        when (action) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> remains()
            "exit" -> break
        }
    }
}

fun remains() {
    println("The coffee machine has:\n" +
            "$waterSupply ml of water\n" +
            "$milkSupply ml of milk\n" +
            "$coffeeSupply g of coffee beans\n" +
            "$cupSupply disposable cups\n" +
            "\$$moneySupply of money")
    println()
}

fun buy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    val type = readln()
    when(type) {
        "1" -> coffee(250, 0, 16, 1, 4)
        "2" -> coffee(350, 75, 20, 1, 7)
        "3" -> coffee(200, 100, 12, 1, 6)
        "back" -> back()
    }
}

fun fill() {
    println("Write how many ml of water you want to add:")
    waterSupply += readln().toInt()
    println("Write how many ml of milk you want to add:")
    milkSupply += readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    coffeeSupply += readln().toInt()
    println("Write how many disposable cups you want to add:")
    cupSupply += readln().toInt()
    println()
}

fun take() {
    println("I gave you \$$moneySupply")
    moneySupply = 0
    println()
}

fun coffee(water: Int, milk: Int, coffee: Int, cup: Int, money: Int) {
    when {
        waterSupply - water < 0 -> println("Sorry, not enough water!")
        moneySupply - milk < 0 -> println("Sorry, not enough milk!")
        coffeeSupply - coffee < 0 -> println("Sorry, not enough coffee!")
        cupSupply - cup < 0 -> println("Sorry, not enough cup!")
        else -> {
            println("I have enough resources, making you a coffee!")
            waterSupply -= water
            milkSupply -= milk
            coffeeSupply -= coffee
            cupSupply -= cup
            moneySupply += money
        }
    }
    println()
}

fun back() {
    println()
}
