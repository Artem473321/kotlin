fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seatsPerRow = readln().toInt()

    val cinema = Cinema(rows, seatsPerRow)

    while (true) {
        println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit")
        when (readLine()!!.toInt()) {
            1 -> cinema.printSeats()
            2 -> cinema.buyTicket()
            3 -> cinema.showStatistics()
            0 -> return
        }
    }
}

class Cinema(private val totalRows: Int, private val seatsPerRow: Int) {
    private val seats = Array(totalRows) { Array(seatsPerRow) { 'S' } }
    private var totalTicketsSold = 0
    private var currentIncome = 0
    private val totalIncome = calculateTotalIncome()

    private fun calculateTotalIncome(): Int {
        val totalSeats = totalRows * seatsPerRow
        return if (totalSeats <= 60) {
            totalSeats * 10
        } else {
            val frontHalf = totalRows / 2 * seatsPerRow
            val backHalf = totalSeats - frontHalf
            frontHalf * 10 + backHalf * 8
        }
    }

    fun printSeats() {
        println("\nCinema:")
        println("${" ".repeat(2)}${(1..seatsPerRow).joinToString(" ")}")
        for (i in seats.indices) {
            println("${i + 1} ${seats[i].joinToString(" ")}")
        }
    }

    fun buyTicket() {
        while (true) {
            println("\nEnter a row number:")
            val row = readln().toInt()
            println("Enter a seat number in that row:")
            val seat = readln().toInt()

            if (row !in 1..totalRows || seat !in 1..seatsPerRow) {
                println("Wrong input!")
                continue
            }

            if (seats[row - 1][seat - 1] == 'B') {
                println("That ticket has already been purchased!")
                continue
            }

            val ticketPrice = calculateTicketPrice(row)
            println("\nTicket price: $$ticketPrice")
            seats[row - 1][seat - 1] = 'B'
            totalTicketsSold++
            currentIncome += ticketPrice
            break
        }
    }

    private fun calculateTicketPrice(row: Int): Int {
        val totalSeats = totalRows * seatsPerRow
        return if (totalSeats <= 60 || row <= totalRows / 2) {
            10
        } else {
            8
        }
    }

    fun showStatistics() {
        val percentage = totalTicketsSold.toDouble() / (totalRows * seatsPerRow) * 100
        println("\nNumber of purchased tickets: $totalTicketsSold")
        println("Percentage: ${"%.2f".format(percentage)}%")
        println("Current income: \$$currentIncome")
        println("Total income: \$$totalIncome")
    }
}