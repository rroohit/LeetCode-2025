package i_september

import java.time.chrono.JapaneseEra.values

/**
 *  Problem 29. Minimum Score Triangulation of Polygon.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O()
 *       - Space complexity: O()
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 2, 3),
        intArrayOf(3, 7, 4, 5),
        intArrayOf(1, 3, 1, 4, 1, 5)
    )

    testCases.forEach { values ->
        println("Result ==> ${minScoreTriangulation(values)}")
    }

}

fun minScoreTriangulation(values: IntArray): Int {

    return 0
}
