package c_march


/**
 *  Problem 19. Minimum Operations to Make Binary Array Elements Equal to One I.
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
        intArrayOf(0, 1, 1, 1, 0, 0),
        intArrayOf(0, 1, 1, 1, 0, 0, 1),
        intArrayOf(0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 1), // 1 - [1, 0, 0, 1] :: 2 - [1, 1, 1, 0]
        intArrayOf(0, 0, 0),
        intArrayOf(1, 0, 0, 1, 1, 0, 1, 1, 1)
    )

    testCases.forEach { nums ->
        println("Result ==> ${minOperations(nums)}")
        println(nums.toList())
        println()
    }

}

fun minOperations(nums: IntArray): Int {
    val n = nums.size

    var operations = 0
    for (i in 2..<n) {
        val first = nums[i - 2]
        if (first == 1) continue
        operations++
        nums[i - 2] = getBinary(nums[i - 2])  // first
        nums[i - 1] = getBinary(nums[i - 1])  // mid
        nums[i] = getBinary(nums[i])// curr
    }
    if (nums[n - 3] + nums[n - 2] + nums[n - 1] != 3) return -1
    return operations
}

private fun getBinary(curr: Int): Int {
    return if (curr == 1) 0 else 1
}