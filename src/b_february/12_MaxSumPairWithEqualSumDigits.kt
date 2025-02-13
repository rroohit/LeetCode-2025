package b_february

import kotlin.math.max

/**
 *  Problem 12. Max Sum of a Pair With Equal Sum of Digits.
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
        intArrayOf(18, 43, 36, 13, 7),
        intArrayOf(10, 12, 19, 14)
    )

    testCases.forEach { nums ->
        println("Result ==> ${maximumSum(nums)}")
    }

}

fun maximumSum(nums: IntArray): Int {
    val map = IntArray(82) { 0 }
    var ans = -1
    for (num in nums) {
        val sum = getSum(num)
        if (map[sum] > 0) {
            ans = max(map[sum] + num, ans)
        }
        map[sum] = max(map[sum], num)
    }

    return ans
}

private fun getSum(num: Int): Int {
    var sum = 0
    var n = num
    while (n > 0) {
        sum += (n % 10)
        n /= 10
    }
    return sum
}