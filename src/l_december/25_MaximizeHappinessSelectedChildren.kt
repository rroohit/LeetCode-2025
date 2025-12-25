package l_december

import java.util.PriorityQueue

fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 2, 3), 2
        ),
        Pair(
            intArrayOf(1, 1, 1, 1), 2
        ),
        Pair(
            intArrayOf(2, 3, 4, 5), 1
        )
    )

    testCases.forEach { (happiness, k) ->
        println("Result ==> ${maximumHappinessSum(happiness, k)}")
    }

}

// TC - O(n log n) :: SC - O(n)
fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
    val maxPQ = PriorityQueue<Int>(compareByDescending { it })
    for (hap in happiness) {
        maxPQ.add(hap)
    }
    var total = 0L
    for (i in 0..< k) {
        val top = maxPQ.poll() ?: 0
        total += if (top - i > 0) top - i else 0
    }
    return total
}

// TC - O(n log n) :: SC - O(n)
fun maximumHappinessSum2(happiness: IntArray, k: Int): Long {
    val maxPQ = PriorityQueue<Int>(compareByDescending { it })
    for (hap in happiness) {
        maxPQ.add(hap)
    }

    var total = 0L
    repeat(k) { i ->
        val top = maxPQ.poll() ?: 0
        total += if (top - i > 0) top - i else 0
    }

    return total
}


// TC - O(n log n) :: SC - O(1) Auxiliary
fun maximumHappinessSum1(happiness: IntArray, k: Int): Long {
    val n = happiness.size - 1
    happiness.sort()
    var steps = 0
    var total = 0L
    while (steps < k) {
        val currVal = (happiness[n - steps] - steps)
        total += if (currVal > 0) currVal else 0
        steps++
    }
    return total
}