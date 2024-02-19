import java.util.*

fun main() {
    println("Task number one")
    var number = readln().toInt()
    val result = if (number % 2 == 0) "Even" else "Odd"
    println(result)

    println("Task number two")
    number = readln().toInt()
    val result2 = if (number % 2 == 0) number * 4 else number * 5
    println(result2)


    println("Task number three")
    number = readln().toInt()
    val result3 = if (number > 0) -number else number
    println(result3)

    println("Task number four")
    number = readln().toInt()
    val result4 = (number / 100) + 1
    println(result4)

    println("Task number five")
    var input = readln()
    val numbers = Collections.min(input.split(" ").map { it.toInt() })
    println(numbers)

    println("Task number six")
    input = readln()
    var numbers2 = input.split(" ").map{ it.toInt() }
    val sortedNumbers = numbers2.sorted()
    val twoLargest = sortedNumbers.takeLast(2)
    println(twoLargest)

    println("Task number seven")
    input = readln()
    numbers2 = input.split(" ").map{ it.toInt() }
    var count1 = 0
    var count2 = 0
    for (i in numbers2){
        if (i > 0){
            count1 += 1
        } else {
            count2 += i
        }
    }
    println(intArrayOf(count1, count2))

    println("Task number eight")
    input = readln()
    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'y')
    var count = 0
    for (i in vowels){
        count += input.count{it == i}
    }

    println("Task number nine")
    input = readln()
    var result5 = ""
    val middleIndex = input.length / 2
    if (input.length % 2 == 0) {
        result5 = input.substring(middleIndex - 1, middleIndex + 1)
    } else {
        result5 = input[middleIndex].toString()
    }
    println(result5)

    println("Task number ten")
    val mainList = mutableListOf<List<Int>>()
    for (i in 1..3){
        mainList += listOf(1 * i, 2 * i, 3 * i)
    }
    println(mainList)
}