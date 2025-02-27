package b_february

import kotlin.math.max

/**
 *  Problem 27. Length of Longest Fibonacci Subsequence.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2)
 *
 *       - Space complexity: O(n^2)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 2, 3, 4, 5, 6, 7, 8),
        intArrayOf(1, 3, 7, 11, 12, 14, 18)
    )

    testCases.forEach { arr ->
        println("Result ==> ${lenLongestFibSubseq(arr)}")
    }

}

fun lenLongestFibSubseq(arr: IntArray): Int {
    val n = arr.size
    val dp = Array(n) { IntArray(n) }
    var maxLen = 0

    for (curr in 2..<n) {
        var start = 0
        var end = curr - 1

        while (start < end) {
            val pairSum = arr[start] + arr[end]
            if (pairSum > arr[curr]) {
                end--
            } else if (pairSum < arr[curr]) {
                start++
            } else {
                dp[end][curr] = dp[start][end] + 1
                maxLen = max(dp[end][curr].toDouble(), maxLen.toDouble()).toInt()
                end--
                start++
            }
        }
    }

    return if (maxLen == 0) 0 else maxLen + 2
}