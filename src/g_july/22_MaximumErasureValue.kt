package g_july

/**
 *  Problem 22. Maximum Erasure Value.
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
        intArrayOf(4, 2, 4, 5, 6),
        intArrayOf(5, 2, 1, 2, 5, 2, 1, 2, 5)
    )

    testCases.forEach { nums ->
        println("Result ==> ${maximumUniqueSubarray(nums)}")
    }

}

fun maximumUniqueSubarray(nums: IntArray): Int {
    val seen = mutableSetOf<Int>()
    var left = 0
    var sum = 0
    var maxSum = 0

    for (right in nums.indices) {
        while (seen.contains(nums[right])) {
            seen.remove(nums[left])
            sum -= nums[left]
            left++
        }
        seen.add(nums[right])
        sum += nums[right]
        maxSum = maxOf(maxSum, sum)
    }

    return maxSum
}