package d_april

import kotlin.math.max
import kotlin.math.min

/**
 *  Problem 21. Count the Hidden Sequences.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple(
            intArrayOf(1, -3, 4), 1, 6
        ),
        Triple(
            intArrayOf(3, -4, 5, 1, -2), -4, 5
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${numberOfArrays(test.first, test.second, test.third)}")
    }

}

fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
    var x = 0
    var y = 0
    var curr = 0
    for (num in differences) {
        curr += num
        x = min(x, curr)
        y = max(y, curr)
        if (y - x > upper - lower) {
            return 0
        }
    }
    return (upper - lower) - (y - x) + 1
}