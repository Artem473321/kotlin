fun main() {
    val values = arrayListOf("Бумага", "Камінь", "Ножиці")
    val game_bit = mapOf("Камінь" to "Бумага", "Бумага" to "Ножиці", "Ножиці" to "Камінь")

    while (true){
        val bot_value = values.random()
        println("Enter a value(Бумага, Камінь, Ножиці)")
        val user_value = readln()

        if (user_value !in values){
            println("Wrong data!")
            continue
        }

        if (game_bit[bot_value] == user_value){
            println("You are win!")
        }else if (bot_value == user_value){
            println("Cant find winner!")
        }else{
            println("You lose!")
        }
        break

    }


}