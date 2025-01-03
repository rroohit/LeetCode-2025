package a_january

/**
 *  Problem 3. Number of Ways to Split Array.
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
        intArrayOf(10, 4, -8, 7),
        intArrayOf(2, 3, 1, 0),
        intArrayOf(1, 2, 3, 4, 5, 6),
        intArrayOf(6, 5, 4, 3, 2, 1)
    )

    testCases.forEach { nums ->
        println("Result ==> ${waysToSplitArray(nums)}")
    }

}

// Prefix Sum -
// TC - O(n)
// SC - O(1)
fun waysToSplitArray(nums: IntArray): Int {
    var ways = 0
    var right = 0L
    var left = 0L

    for (num in nums) right += num

    for (i in 0..nums.size - 2) {
        left += nums[i]
        right -= nums[i]
        if (left >= right) ways++
    }

    return ways
}