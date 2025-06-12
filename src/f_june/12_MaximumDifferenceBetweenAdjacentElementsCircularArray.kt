package f_june

import kotlin.math.abs
import kotlin.math.max

/**
 *  Problem 12. Maximum Difference Between Adjacent Elements in a Circular Array.
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
        intArrayOf(1, 2, 3)
    )

    testCases.forEach { nums ->
        println("Result ==> ${maxAdjacentDistance(nums)}")
    }

}

fun maxAdjacentDistance(nums: IntArray): Int {
    var maxDiff = abs(nums.first() - nums.last())
    for (i in 1..<nums.size) {
        val diff = abs(nums[i] - nums[i - 1])
        maxDiff = max(diff, maxDiff)
    }
    return maxDiff
}
