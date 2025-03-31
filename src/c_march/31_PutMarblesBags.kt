package c_march

import java.util.*


/**
 *  Problem 31. Put Marbles in Bags.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n log n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 3, 5, 1), 2
        ),
        Pair(
            intArrayOf(1, 3), 2
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${putMarbles(test.first, test.second)}")
    }

}

fun putMarbles(weights: IntArray, k: Int): Long {
    val n = weights.size
    val pairWeights = LongArray(n - 1)
    for (i in 0..<n - 1) {
        pairWeights[i] = weights[i].toLong() + weights[i + 1]
    }
    Arrays.sort(pairWeights, 0, n - 1)

    var answer = 0L
    for (i in 0..<k - 1) {
        answer += (pairWeights[n - 2 - i] - pairWeights[i])
    }

    return answer
}