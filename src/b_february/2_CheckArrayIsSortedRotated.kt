package b_february

/**
 *  Problem 2. Check if Array Is Sorted and Rotated.
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
        intArrayOf(3, 4, 5, 1, 2),
        intArrayOf(2, 1, 3, 4),
        intArrayOf(1, 2, 3),
        intArrayOf(1, 1, 2, 1),
        intArrayOf(2, 3, 4, 4, 5, 0, 1)
    )

    testCases.forEach { nums ->
        println("Result ==> ${check(nums)}")
        println()
    }

}

fun check(nums: IntArray): Boolean {
    val n = nums.size
    var l = 0
    for (i in 1..<n) {
        if (nums[i - 1] > nums[i]) {
            l = i
            break
        }
    }

    for (i in 1..<n) {
        val curr = nums[(l + i) % n]
        val prev = nums[(l + i - 1) % n]
        if (prev > curr) return false
    }

    return true
}