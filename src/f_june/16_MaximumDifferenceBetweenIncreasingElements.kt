package f_june

import kotlin.math.max

/**
 *  Problem 16. Maximum Difference Between Increasing Elements.
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
        intArrayOf(7, 1, 5, 4),
        intArrayOf(9, 4, 3, 2),
        intArrayOf(1, 5, 2, 10)
    )

    testCases.forEach { nums ->
        println("Result ==> ${maximumDifference(nums)}")
    }

}

fun maximumDifference(nums: IntArray): Int {
    val n = nums.size
    var ans = -1
    var premin = nums[0]
    for (i in 1..<n) {
        if (nums[i] > premin) {
            ans = max(ans, nums[i] - premin)
        } else {
            premin = nums[i]
        }
    }
    return ans
}
