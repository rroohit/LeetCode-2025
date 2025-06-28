package f_june

import java.util.*

/**
 *  Problem 28. Find Subsequence of Length K With the Largest Sum.
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
            intArrayOf(2, 1, 3, 3), 2
        )
    )

    testCases.forEach { (nums, k) ->
        println("Result ==> ${maxSubsequence(nums, k).toList()}")
    }

}

fun maxSubsequence(nums: IntArray, k: Int): IntArray {
    val n = nums.size
    val vals = Array(n) { IntArray(2) }
    for (i in 0..<n) {
        vals[i][0] = i
        vals[i][1] = nums[i]
    }

    Arrays.sort(vals, Comparator { x1: IntArray?, x2: IntArray? -> x2!![1].compareTo(x1!![1]) })

    Arrays.sort(
        vals,
        0,
        k,
        Comparator { x1: IntArray?, x2: IntArray? -> x1!![0].compareTo(x2!![0]) })

    val res = IntArray(k)

    for (i in 0..<k) {
        res[i] = vals[i][1]
    }
    return res
}
