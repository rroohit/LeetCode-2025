package d_april

/**
 *  Problem 6. Largest Divisible Subset.
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
        intArrayOf(1, 2, 3),
        intArrayOf(1, 2, 4, 8)
    )

    testCases.forEach { nums ->
        println("Result ==> ${largestDivisibleSubset(nums)}")
    }

}


fun largestDivisibleSubset(nums: IntArray): List<Int> {
    nums.sort()
    val dp = Array(nums.size) { mutableListOf<Int>() }
    for (i in nums.indices) {
        dp[i].add(nums[i])
    }
    var res = emptyList<Int>()

    for (i in nums.size - 1 downTo 0) {
        for (j in i + 1..<nums.size) {
            if (nums[j] % nums[i] == 0) {
                val temp = listOf(nums[i]).plus(dp[j])
                if (temp.size > dp[i].size) {
                    dp[i].clear()
                    dp[i].addAll(temp)
                }
            }
        }
        if (dp[i].size > res.size) res = dp[i]
    }

    return res
}