package d_april

/**
 *  Problem 19. Count the Number of Fair Pairs.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n logn)
 *
 *       - Space complexity: O(logn)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple(
            intArrayOf(0, 1, 7, 4, 4, 5), 3, 6
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${countFairPairs(test.first, test.second, test.third)}")
    }

}

fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
    nums.sort()
    return lowerBound(nums, upper + 1) - lowerBound(nums, lower)
}

private fun lowerBound(nums: IntArray, value: Int): Long {
    var left = 0
    var right = nums.size - 1
    var result: Long = 0
    while (left < right) {
        val sum = nums[left] + nums[right]
        if (sum < value) {
            result += (right - left).toLong()
            left++
        } else {
            right--
        }
    }
    return result
}