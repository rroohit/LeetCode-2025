package c_march

import kotlin.math.max

/**
 *  Problem 12. Maximum Count of Positive Integer and Negative Integer.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O()
 *
 *       - Space complexity: O()
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(-2, -1, -1, 1, 2, 3),
        intArrayOf(-3, -2, -1, 0, 0, 1, 2),
        intArrayOf(5, 20, 66, 1314)
    )

    testCases.forEach { nums ->
        println("Result ==> ${maximumCount(nums)}")
    }

}


// TC - O(n) :: SC - O(1)
fun maximumCount(nums: IntArray): Int {
    var pos = 0
    var neg = 0
    for (num in nums) {
        if (num > 0) pos++
        if (num < 0) neg++
    }
    return max(pos, neg)
}