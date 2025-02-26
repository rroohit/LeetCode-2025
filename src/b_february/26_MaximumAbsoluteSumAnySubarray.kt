package b_february

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 *  Problem 26. Maximum Absolute Sum of Any Subarray.
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
        intArrayOf(1, -3, 2, 3, -4),
        intArrayOf(2, -5, 1, -4, 3, -2)
    )

    testCases.forEach { nums ->
        println("Result ==> ${maxAbsoluteSum(nums)}")
    }

}

fun maxAbsoluteSum(nums: IntArray): Int {
    var minPrefixSum = 0
    var maxPrefixSum = 0
    var prefixSum = 0

    for (i in nums.indices) {
        prefixSum += nums[i]
        minPrefixSum = min(minPrefixSum, prefixSum)
        maxPrefixSum = max(maxPrefixSum, prefixSum)
    }

    return maxPrefixSum - minPrefixSum
}

// TC - O(n) :: SC - O(1)
fun maxAbsoluteSum2(nums: IntArray): Int {
    var minPrefixSum = Int.MAX_VALUE
    var maxPrefixSum = Int.MIN_VALUE
    var prefixSum = 0
    var maxAbsSum = 0

    for (i in nums.indices) {
        prefixSum += nums[i]

        minPrefixSum = min(minPrefixSum, prefixSum)
        maxPrefixSum = max(maxPrefixSum, prefixSum)

        maxAbsSum = if (prefixSum >= 0) {
            max(maxAbsSum, max(prefixSum, (prefixSum - minPrefixSum)))
        } else {
            max(
                maxAbsSum, max(abs(prefixSum), abs((prefixSum - maxPrefixSum)))
            )
        }
    }

    return maxAbsSum
}


// TLE -
fun maxAbsoluteSum1(nums: IntArray): Int {
    var maxSum = Int.MIN_VALUE
    for (i in nums.indices) {
        var sum = nums[i]
        for (j in i + 1..<nums.size) {
            sum += nums[j]
            maxSum = max(abs(sum), maxSum)
        }
    }
    return maxSum
}