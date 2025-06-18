package f_june

import java.util.*

/**
 *  Problem 18. Divide Array Into Arrays With Max Difference.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(nlogn)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 3, 4, 8, 7, 9, 3, 5, 1), 2
        )
    )

    testCases.forEach { (nums, k) ->
        println("Result ==> ${divideArray(nums, k).toList()}")
    }

}

fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
    Arrays.sort(nums)
    val ans = Array(nums.size / 3) { IntArray(3) }
    var i = 0
    while (i < nums.size) {
        if (nums[i + 2] - nums[i] > k) {
            return Array<IntArray>(0) { IntArray(0) }
        }
        ans[i / 3] = intArrayOf(nums[i], nums[i + 1], nums[i + 2])
        i += 3
    }
    return ans
}
