package l_december

import java.util.PriorityQueue

fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(1, 3, 2),
            intArrayOf(4, 5, 2),
            intArrayOf(2, 4, 3)
        )
    )

    testCases.forEach { events ->
        println("Result ==> ${maxTwoEvents(events)}")
    }

}

fun maxTwoEvents(events: Array<IntArray>): Int {
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
    events.sortWith(compareBy { it[0] })

    var maxVal = 0
    var maxSum = 0

    for (event in events) {
        val start = event[0]
        val end = event[1]
        val value = event[2]

        while (pq.isNotEmpty() && pq.peek().first < start) {
            maxVal = maxOf(maxVal, pq.poll().second)
        }

        maxSum = maxOf(maxSum, maxVal + value)
        pq.add(Pair(end, value))
    }

    return maxSum
}