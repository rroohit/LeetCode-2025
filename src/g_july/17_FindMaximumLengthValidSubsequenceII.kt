package g_july

import kotlin.math.max

/**
 *  Problem 17. Find the Maximum Length of Valid Subsequence II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(k^2 * n * k)
 *
 *       - Space complexity: O(k^2)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(intArrayOf(1, 2, 3, 4, 5), 2),
        Pair(intArrayOf(1, 4, 2, 3, 1, 4), 3)
    )

    testCases.forEach { (nums, k) ->
        println("Result ==> ${maximumLength(nums, k)}")
    }

}

fun maximumLength(nums: IntArray, k: Int): Int {
    val dp = Array(k) { IntArray(k) }
    var res = 0
    for (num in nums) {
        var num = num
        num %= k
        for (prev in 0..<k) {
            dp[prev][num] = dp[num][prev] + 1
            res = max(res, dp[prev][num])
        }
    }
    return res
}
