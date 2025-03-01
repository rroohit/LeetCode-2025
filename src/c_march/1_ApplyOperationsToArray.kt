package c_march

/**
 *  Problem 1. Apply Operations to an Array.
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
        intArrayOf(1, 2, 2, 1, 1, 0),
        intArrayOf(0, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(1, 1, 1)

    )

    // 0, 0, 0, 1,
    testCases.forEach { nums ->
        println("Result ==> ${applyOperations(nums).toList()}")
    }

}

fun applyOperations(nums: IntArray): IntArray {
    for (i in 0..nums.size - 2) {
        if (nums[i] == 0) continue
        if (nums[i] == nums[i + 1]) {
            nums[i] *= 2
            nums[i + 1] = 0
        }
    }

    var l = 0
    for (r in nums.indices) {
        if (nums[r] != 0) {
            nums[l++] = nums[r]
        }
    }

    while (l < nums.size) nums[l++] = 0
    return nums
}