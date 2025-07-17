package g_july

import kotlin.math.max

/**
 *  Problem 16. Find the Maximum Length of Valid Subsequence I.
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
        intArrayOf(1, 2, 3, 4),
        intArrayOf(1, 2, 1, 1, 2, 1, 2),
        intArrayOf(1, 3)
    )

    testCases.forEach { nums ->
        println("Result ==> ${maximumLength(nums)}")
    }

}

private fun maximumLength(nums: IntArray): Int {
    var res = 0
    val patterns = arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, 1))
    for (pattern in patterns) {
        var cnt = 0
        for (num in nums) {
            if (num % 2 == pattern[cnt % 2]) {
                cnt++
            }
        }
        res = max(res, cnt)
    }
    return res
}
