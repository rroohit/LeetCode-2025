package c_march

import kotlin.math.max

/**
 *  Problem 18. Longest Nice Subarray.
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
        intArrayOf(1, 3, 8, 48, 10),
        intArrayOf(3, 1, 5, 11, 13)
    )

    testCases.forEach { nums ->
        println("Result ==> ${longestNiceSubarray(nums)}")
    }

}

fun longestNiceSubarray(nums: IntArray): Int {
    var usedBits = 0
    var windowStart = 0
    var maxLength = 0

    for (windowEnd in nums.indices) {
        while ((usedBits and nums[windowEnd]) != 0) {
            usedBits = usedBits xor nums[windowStart]
            windowStart++
        }

        usedBits = usedBits or nums[windowEnd]
        maxLength = max(maxLength, (windowEnd - windowStart + 1))
    }

    return maxLength
}