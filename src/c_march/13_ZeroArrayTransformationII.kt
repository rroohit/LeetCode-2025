package c_march

import kotlin.math.max

/**
 *  Problem 13. Zero Array Transformation II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(2, 0, 2),
            arrayOf(
                intArrayOf(0, 2, 1), intArrayOf(0, 2, 1), intArrayOf(1, 1, 3)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minZeroArray(test.first, test.second)}")
    }

}

fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
    val n = nums.size
    var sum = 0
    var k = 0
    val differenceArray = IntArray(n + 1)
    for (index in 0..<n) {
        while (sum + differenceArray[index] < nums[index]) {
            k++
            if (k > queries.size) return -1
            val left = queries[k - 1][0]
            val right = queries[k - 1][1]
            val value = queries[k - 1][2]

            if (right >= index) {
                differenceArray[max(left, index)] += value
                differenceArray[right + 1] -= value
            }
        }
        sum += differenceArray[index]
    }
    return k
}
