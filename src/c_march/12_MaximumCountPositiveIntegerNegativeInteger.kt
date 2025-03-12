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
 *       - Time complexity: O(logn)
 *
 *       - Space complexity: O(1)
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

fun maximumCount(nums: IntArray): Int {
    val n = nums.size
    var l = 0
    var r = n - 1

    while (l < r) {
        val mid = l + (r - l) / 2
        if (nums[mid] >= 0) r = mid else l = mid + 1
    }

    val neg = l
    l = 0
    r = n - 1
    while (l < r) {
        val mid = l + (r - l) / 2
        if (nums[mid] >= 1) r = mid else l = mid + 1
    }

    return max(neg, n - l)
}


// TC - O(n) :: SC - O(1)
fun maximumCount1(nums: IntArray): Int {
    var pos = 0
    var neg = 0
    for (num in nums) {
        if (num > 0) pos++
        if (num < 0) neg++
    }
    return max(pos, neg)
}