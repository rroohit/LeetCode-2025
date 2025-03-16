package c_march

import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

/**
 *  Problem 16.  Minimum Time to Repair Cars.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + max_rank log (m * max_rank))
 *
 *       - Space complexity: O(max_rank)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(4, 2, 3, 1), 10
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${repairCars(test.first, test.second)}")
    }

}

fun repairCars(ranks: IntArray, cars: Int): Long {
    var minRank = ranks[0]
    var maxRank = ranks[0]

    for (rank in ranks) {
        minRank = min(minRank, rank)
        maxRank = max(maxRank, rank)
    }

    val freq = IntArray(maxRank + 1)
    for (rank in ranks) {
        minRank = min(minRank, rank)
        freq[rank]++
    }

    var low: Long = 1
    var high = 1L * minRank * cars * cars

    while (low < high) {
        val mid = (low + high) / 2
        var carsRepaired: Long = 0

        for (rank in 1..maxRank) {
            carsRepaired += freq[rank] * sqrt((mid / rank.toLong()).toDouble()).toLong()
        }

        if (carsRepaired >= cars) {
            high = mid
        } else {
            low = mid + 1
        }
    }

    return low
}

