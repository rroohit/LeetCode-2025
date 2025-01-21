package a_january

import kotlin.math.max
import kotlin.math.min

/**
 *  Problem 21. Grid Game.
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
        arrayOf(
            intArrayOf(2, 5, 4),
            intArrayOf(1, 5, 1)
        ),
        arrayOf(
            intArrayOf(3, 3, 1),
            intArrayOf(8, 5, 2)
        )
    )

    testCases.forEach { grid ->
        println("Result ==> ${gridGame(grid)}")
    }

}

fun gridGame(grid: Array<IntArray>): Long {
    var firstRowSum: Long = 0
    for (num in grid[0]) {
        firstRowSum += num.toLong()
    }
    var secondRowSum: Long = 0
    var minimumSum = Long.MAX_VALUE
    for (turnIndex in 0..<grid[0].size) {
        firstRowSum -= grid[0][turnIndex]
        minimumSum = min(minimumSum, max(firstRowSum, secondRowSum))
        secondRowSum += grid[1][turnIndex]
    }
    return minimumSum
}