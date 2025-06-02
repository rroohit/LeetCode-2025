package f_june

import kotlin.math.max

/**
 *  Problem 2. Candy.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 0, 2),
        intArrayOf(1, 2, 2)
    )

    testCases.forEach { ratings ->
        println("Result ==> ${candy(ratings)}")
    }

}

fun candy(ratings: IntArray): Int {
    val n = ratings.size
    val candy = IntArray(n) { 1 }

    // left neighbors.
    for (i in 1..<n) {
        val left = ratings[i - 1]
        val curRat = ratings[i]
        if (curRat > left) {
            candy[i] = candy[i - 1] + 1
        }
    }

    // right neighbors
    for (i in n - 2 downTo 0) {
        val right = ratings[i + 1]
        val curRat = ratings[i]
        if (curRat > right) {
            candy[i] = max(candy[i], candy[i + 1] + 1)
        }
    }

    return candy.sum()

}