package d_april

/**
 *  Problem 8. Minimum Number of Operations to Make Elements in Array Distinct.
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
        intArrayOf(1, 2, 3, 4, 2, 3, 3, 5, 7),
        intArrayOf(4, 5, 6, 4, 4)
    )

    testCases.forEach { nums ->
        println("Result ==> ${minimumOperations(nums)}")
    }

}

fun minimumOperations(nums: IntArray): Int {
    val seen = IntArray(101)
    for (i in nums.size - 1 downTo 0) {
        if (seen[nums[i]] > 0) {
            return (i / 3) + 1
        }
        seen[nums[i]]++
    }
    return 0
}