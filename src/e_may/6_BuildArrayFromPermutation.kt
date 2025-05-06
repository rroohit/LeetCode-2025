package e_may

/**
 *  Problem 6. Build Array from Permutation.
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
        intArrayOf(0, 2, 1, 5, 3, 4),
        intArrayOf(5, 0, 1, 2, 3, 4)
    )

    testCases.forEach { nums ->
        println("Result ==> ${buildArray(nums).toList()}")
    }

}

// TC - O(n) :: SC - O(n)
fun buildArray(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    for (i in nums.indices) {
        result[i] = nums[nums[i]]
    }
    return result
}