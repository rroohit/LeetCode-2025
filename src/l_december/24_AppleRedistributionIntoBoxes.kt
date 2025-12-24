package l_december

fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 3, 2),
            intArrayOf(4, 3, 1, 5, 2)
        )
    )

    testCases.forEach { (apple, capacity) ->
        println("Result ==> ${minimumBoxes(apple, capacity)}")
    }

}

fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
    val n = capacity.size
    val boxes = IntArray(52)
    for (b in capacity) boxes[b]++

    var total = 0
    for (app in apple) total += app

    var req = 0
    for (i in 51 downTo 0) {
        while (total > 0 && boxes[i] > 0) {
            total -= i
            boxes[i]--
            req++
        }
        if (total <= 0) break
    }

    return req
}