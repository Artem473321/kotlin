
fun main() {
    val coffeeMachine = CoffeeMachine()
    coffeeMachine.processActions()
}

class CoffeeMachine {
    private var water = 400
    private var milk = 540
    private var coffeeBeans = 120
    private var disposableCups = 9
    private var money = 550

    fun processActions() {
        while (true) {
            print("Write action (buy, fill, take, remaining, exit): ")
            when (readln().trim()) {
                "buy" -> buyCoffee()
                "fill" -> fillIngredients()
                "take" -> takeMoney()
                "remaining" -> printRemaining()
                "exit" -> break
            }
        }
    }

    private fun buyCoffee() {
        while (true) {
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
            when (readln().trim()) {
                "1" -> makeCoffee(250, 0, 16, 4)
                "2" -> makeCoffee(350, 75, 20, 7)
                "3" -> makeCoffee(200, 100, 12, 6)
                "back" -> break
            }
        }
    }

    private fun makeCoffee(waterNeeded: Int, milkNeeded: Int, coffeeBeansNeeded: Int, price: Int) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= coffeeBeansNeeded && disposableCups >= 1) {
            println("I have enough resources, making you a coffee!")
            water -= waterNeeded
            milk -= milkNeeded
            coffeeBeans -= coffeeBeansNeeded
            disposableCups--
            money += price
        } else {
            println("Sorry, not enough resources to make coffee!")
        }
    }

    private fun fillIngredients() {
        println("Write how many ml of water you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        coffeeBeans += readln().toInt()
        println("Write how many disposable coffee cups you want to add:")
        disposableCups += readln().toInt()
    }

    private fun takeMoney() {
        println("I gave you $$money")
        money = 0
    }

    private fun printRemaining() {
        println("The coffee machine has:")
        println("$water of water")
        println("$milk of milk")
        println("$coffeeBeans of coffee beans")
        println("$disposableCups of disposable cups")
        println("$$money of money")
    }
}
