package b_february

/**
 *  Problem 4. Maximum Ascending Subarray Sum.
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
        intArrayOf(10, 20, 30, 5, 10, 50),
        intArrayOf(10, 20, 30, 40, 50),
        intArrayOf(12, 17, 15, 13, 10, 11, 12),
        intArrayOf(3, 6, 10, 1, 8, 9, 9, 8, 9)
    )

    testCases.forEach { nums ->
        println("Result ==> ${maxAscendingSum(nums)}")
    }

}

fun maxAscendingSum(nums: IntArray): Int {
    var maxSum = nums[0]
    var currSum = maxSum
    for (i in 1..<nums.size) {
        if (nums[i - 1] >= nums[i]) currSum = 0
        currSum += nums[i]
        if (currSum > maxSum) maxSum = currSum
    }
    return maxSum
}