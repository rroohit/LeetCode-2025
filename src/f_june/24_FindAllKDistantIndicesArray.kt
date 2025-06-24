package f_june

import kotlin.math.max
import kotlin.math.min


/**
 *  Problem 24. Find All K-Distant Indices in an Array.
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
        Triple(
            intArrayOf(3, 4, 9, 1, 3, 9, 5), 9, 1
        )
    )

    testCases.forEach { (nums, key, k) ->
        println("Result ==> ${findKDistantIndices(nums, key, k)}")
    }

}

fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
    val res: MutableList<Int> = ArrayList()
    var r = 0
    val n = nums.size
    for (j in 0..<n) {
        if (nums[j] == key) {
            val l = max(r, j - k)
            r = min(n - 1, j + k) + 1
            for (i in l..<r) {
                res.add(i)
            }
        }
    }
    return res
}
