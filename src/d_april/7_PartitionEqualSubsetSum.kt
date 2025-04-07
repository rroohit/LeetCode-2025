package d_april

/**
 *  Problem 7. Partition Equal Subset Sum.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * targetSum)
 *
 *       - Space complexity: O(targetSum)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 5, 11, 5),
        intArrayOf(1, 2, 3, 5),
        intArrayOf(1, 1, 1, 1),
        intArrayOf(5, 3, 2)
    )

    testCases.forEach { nums ->
        println("Result ==> ${canPartition(nums)}")
    }

}

fun canPartition(nums: IntArray): Boolean {
    var totalSum = 0
    for (num in nums) totalSum += num
    if (totalSum % 2 != 0) return false

    val targetSum = totalSum / 2
    val dp = BooleanArray(targetSum + 1)
    dp[0] = true
    for (num in nums) {
        for (sum in targetSum downTo num) {
            dp[sum] = dp[sum] || dp[sum - num]
        }
    }

    return dp[targetSum]
}

// Time Limit Exceeds
// TC - O(n * targetSum) :: SC - O(n * targetSum)
fun canPartition1(nums: IntArray): Boolean {
    var totalSum = 0
    for (num in nums) totalSum += num
    if (totalSum % 2 != 0) return false

    val targetSum = totalSum / 2
    val memo: Array<Array<Boolean?>> = Array(nums.size) { Array<Boolean?>(targetSum + 1) { null } }
    return dfsSubset(0, targetSum, nums, memo)
}

private fun dfsSubset(i: Int, sum: Int, nums: IntArray, memo: Array<Array<Boolean?>>): Boolean {
    if (sum < 0 || i >= nums.size) return false
    if (sum == 0) return true
    memo[i][sum]?.let { return it }
    return dfsSubset(i + 1, sum - nums[i], nums, memo) || dfsSubset(i + 1, sum, nums, memo)
}



