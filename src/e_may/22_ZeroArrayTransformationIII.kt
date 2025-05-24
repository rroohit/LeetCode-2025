package e_may

import java.util.*

/**
 *  Problem 22. Zero Array Transformation III.
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
        Pair(
            intArrayOf(2, 0, 2),
            arrayOf(
                intArrayOf(0, 2),
                intArrayOf(0, 2),
                intArrayOf(1, 1)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${maxRemoval(test.first, test.second)}")
    }

}

fun maxRemoval(nums: IntArray, queries: Array<IntArray>): Int {
    var minQueryCount = 0
    val sortedQueries = queries.sortedBy { (left, right) -> left }
    var qIndex = 0

    val delta = IntArray(nums.size + 1)
    var reduction = 0

    val queryPq = PriorityQueue<Int>(reverseOrder())

    for ((i, num) in nums.withIndex()) {
        while (qIndex < sortedQueries.size && sortedQueries[qIndex][0] <= i) {
            queryPq.add(sortedQueries[qIndex][1])
            qIndex++
        }

        reduction += delta[i]
        while (reduction < num && queryPq.isNotEmpty() && i <= queryPq.peek()) {
            val right: Int = queryPq.poll()
            reduction++
            delta[right + 1]--
            minQueryCount++
        }

        if (reduction < num) {
            return -1
        }
    }

    return queries.size - minQueryCount
}