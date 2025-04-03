package d_april

import kotlin.math.max

/**
 *  Problem 3. Maximum Value of an Ordered Triplet II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(12, 6, 1, 2, 9),
        intArrayOf(1, 10, 3, 4, 19),
        intArrayOf(1, 2, 3)
    )

    testCases.forEach { nums ->
        println("Result ==> ${maximumTripletValue2(nums)}")
    }

}

fun maximumTripletValue2(nums: IntArray): Long {
    val n = nums.size
    val riPref = IntArray(n)
    var rightPref = 0
    for (i in n - 1 downTo 0) {
        rightPref = max(rightPref, nums[i])
        riPref[i] = rightPref
    }

    var ans = 0L
    var leftPref = nums[0]

    for (i in 1..n - 2) {
        ans = max(ans, (leftPref - nums[i]) * riPref[i + 1].toLong())
        leftPref = max(leftPref, nums[i])
    }

    return ans
}