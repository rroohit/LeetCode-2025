package d_april

import kotlin.math.max

/**
 *  Problem 2. Maximum Value of an Ordered Triplet I.
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
        intArrayOf(12, 6, 1, 2, 7),
        intArrayOf(1, 10, 3, 4, 19),
        intArrayOf(1, 2, 3),
        intArrayOf(3, 3, 3)
    )

    testCases.forEach { nums ->
        println("Result ==> ${maximumTripletValue(nums)}")
    }

}

fun maximumTripletValue(nums: IntArray): Long {
    val n = nums.size
    val rightPref = IntArray(n)
    var rightMax = 0
    for (i in n - 1 downTo 0) {
        rightMax = max(rightMax, nums[i])
        rightPref[i] = rightMax
    }

    var ans = 0L
    var leftMax = nums[0]
    for (i in 1..n - 2) {
        ans = max(ans, (leftMax - nums[i]) * rightPref[i].toLong())
        leftMax = max(leftMax, nums[i])
    }

    return ans
}


fun maximumTripletValue1(nums: IntArray): Long {
    val n = nums.size
    var ans = 0L
    for (i in 0..<n) {
        for (j in i + 1..<n) {
            for (k in j + 1..<n) {
                ans = max(
                    ans,
                    (nums[i].toLong() - nums[j].toLong()) * nums[k]
                )
            }
        }
    }
    return ans
}