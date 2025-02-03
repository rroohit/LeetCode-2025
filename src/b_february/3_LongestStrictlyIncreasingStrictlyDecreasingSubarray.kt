package b_february

import kotlin.math.max

/**
 *  Problem 3. Longest Strictly Increasing or Strictly Decreasing Subarray.
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
        intArrayOf(1, 4, 3, 3, 2),
        intArrayOf(3, 3, 3, 3),
        intArrayOf(3, 2, 1)
    )

    testCases.forEach { nums ->
        println("Result ==> ${longestMonotonicSubarray(nums)}")
    }

}

fun longestMonotonicSubarray(nums: IntArray): Int {
    var longest = 1
    var l1 = 0 // left index for increasing order
    var l2 = 0 // left index for decreasing order
    for (r in 1..<nums.size) {
        if (nums[r] <= nums[r - 1]) l1 = r
        if (nums[r] >= nums[r - 1]) l2 = r
        longest = max(longest, r - l1 + 1)
        longest = max(longest, r - l2 + 1)
    }
    return longest
}
