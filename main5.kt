interface Queue<T : Any> {
    fun enqueue(element: T): Boolean
    fun dequeue(): T?
    val count: Int
        get
    val isEmpty: Boolean
        get() = count == 0
    fun peek(): T?
}

class Queue2<T : Any> : Queue<T> {
    private val elements = ArrayList<T>()

    override fun enqueue(element: T): Boolean {
        elements.add(element)
        return true
    }

    override fun dequeue(): T? {
        return if (!isEmpty) {
            elements.removeAt(0)
        } else {
            null
        }
    }

    override val count: Int
        get() = elements.size

    override fun peek(): T? {
        return if (!isEmpty) {
            elements[0]
        } else {
            null
        }
    }

    override val isEmpty: Boolean
        get() = elements.isEmpty()
}

fun main() {
    val queue = Queue2<Int>()

    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)

    println(queue.dequeue()) // 1
    println(queue.dequeue()) // 2

    println(queue.peek()) // 3

    println("Count: ${queue.count}") // Count: 1
}