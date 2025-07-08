package g_july

import java.util.*
import kotlin.math.max


/**
 *  Problem 8. Maximum Number of Events That Can Be Attended II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * (k + logn))
 *
 *       - Space complexity: O(n * k)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            arrayOf(
                intArrayOf(1, 2, 4),
                intArrayOf(3, 4, 3),
                intArrayOf(2, 3, 1)
            ),
            2
        )
    )

    testCases.forEach { (events, k) ->
        println("Result ==> ${maxValue(events, k)}")
    }

}

fun maxValue(events: Array<IntArray>, k: Int): Int {
    val n = events.size
    val dp = Array(k + 1) { IntArray(n + 1) }
    Arrays.sort(events, Comparator { a: IntArray, b: IntArray -> a[0] - b[0] })

    for (curIndex in n - 1 downTo 0) {
        val nextIndex = bisectRight(events, events[curIndex][1])
        for (count in 1..k) {
            dp[count][curIndex] = max(dp[count][curIndex + 1], events[curIndex][2] + dp[count - 1][nextIndex])
        }
    }
    return dp[k][0]
}

fun bisectRight(events: Array<IntArray>, target: Int): Int {
    var left = 0
    var right = events.size
    while (left < right) {
        val mid = (left + right) / 2
        if (events[mid][0] <= target) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}
