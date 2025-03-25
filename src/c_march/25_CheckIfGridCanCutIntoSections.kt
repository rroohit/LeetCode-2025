package c_march

import java.util.*
import kotlin.math.max


/**
 *  Problem 25. Check if Grid can be Cut into Sections.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n log n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            4,
            arrayOf(
                intArrayOf(1, 0, 5, 2),
                intArrayOf(0, 2, 2, 4),
                intArrayOf(3, 2, 5, 3),
                intArrayOf(0, 4, 4, 5)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${checkValidCuts(test.first, test.second)}")
    }

}


fun checkValidCuts(n: Int, rectangles: Array<IntArray>): Boolean {
    return checkCuts(rectangles, 0) || checkCuts(rectangles, 1)
}

private fun checkCuts(rectangles: Array<IntArray>, dim: Int): Boolean {
    var gapCount = 0

    Arrays.sort(rectangles) { a: IntArray, b: IntArray -> a[dim].compareTo(b[dim]) }

    var furthestEnd = rectangles[0][dim + 2]

    for (i in 1..<rectangles.size) {
        val rect = rectangles[i]

        if (furthestEnd <= rect[dim]) {
            gapCount++
        }

        furthestEnd = max(furthestEnd.toDouble(), rect[dim + 2].toDouble()).toInt()
    }

    return gapCount >= 2
}