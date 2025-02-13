package b_february

import java.util.*

/**
 *  Problem 13. Minimum Operations to Exceed Threshold Value II.
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
        Pair(
            intArrayOf(2, 11, 10, 1, 3),
            10
        ),
        Pair(
            intArrayOf(1, 1, 2, 4, 9), 20
        ),
        Pair(
            intArrayOf(1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999),
            1000000000
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minOperations(test.first, test.second)}")
    }

}

fun minOperations(nums: IntArray, k: Int): Int {
    val qu = PriorityQueue<Long>()
    for (num in nums) qu.offer(num.toLong())

    var operation = 0
    while (qu.size > 1 && qu.peek() < k) {
        qu.offer( qu.poll()!! * 2 + qu.poll()!!)
        operation++
    }

    return operation
}