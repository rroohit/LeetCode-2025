package d_april

import kotlin.math.abs

/**
 *  Problem 14. Count Good Triplets.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n ^ 3)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(3, 0, 1, 1, 9, 7),
            intArrayOf(7, 2, 3)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${countGoodTriplets(test.first, test.second[0], test.second[1], test.second[2])}")
    }

}

fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
    val n = arr.size
    var count = 0
    for (i in 0..<n) {
        for (j in i + 1..<n) {
            for (k in j + 1..<n) {
                if (abs(arr[i] - arr[j]) <= a && abs(arr[j] - arr[k]) <= b && abs(arr[i] - arr[k]) <= c) count++
            }
        }
    }

    return count
}