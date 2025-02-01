package b_february

/**
 *  Problem 1. Special Array I.
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
        intArrayOf(1),
        intArrayOf(2, 1, 4),
        intArrayOf(4, 3, 1, 6),
        intArrayOf(3, 4, 1, 6),
        intArrayOf(1, 1)
    )

    testCases.forEach { nums ->
        println("Result ==> ${isArraySpecial(nums)}")
    }

}

fun isArraySpecial(nums: IntArray): Boolean {
    for (i in 1..<nums.size) {
        if (nums[i] % 2 == nums[i - 1] % 2) return false
    }
    return true
}