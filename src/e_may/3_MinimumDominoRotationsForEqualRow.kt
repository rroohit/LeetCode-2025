package e_may

import kotlin.math.max
import kotlin.math.min

/**
 *  Problem 3. Minimum Domino Rotations For Equal Row.
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
        Pair(
            intArrayOf(2, 1, 2, 4, 2, 2),
            intArrayOf(5, 2, 6, 2, 3, 2)
        ),
        Pair(
            intArrayOf(1, 2, 1, 1, 1, 2, 2, 2),
            intArrayOf(2, 1, 2, 2, 2, 2, 2, 2)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minDominoRotations(test.first, test.second)}")
    }

}

fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
    val topRot = validateX(tops[0], tops, bottoms)
    val botRot = validateX(bottoms[0], tops, bottoms)
    return if (topRot == -1 || botRot == -1) {
        max(topRot, botRot)
    } else {
        min(topRot, botRot)
    }
}

private fun validateX(x: Int, tops: IntArray, bottoms: IntArray): Int {
    var topCnt = 0 // top rotation
    var botCnt = 0 // bottom rotation
    for (i in tops.indices) {
        val top = tops[i]
        val bot = bottoms[i]
        if (x != top && x != bot) return -1
        if (x != top) topCnt++
        if (x != bot) botCnt++
    }
    return min(topCnt, botCnt)
}



