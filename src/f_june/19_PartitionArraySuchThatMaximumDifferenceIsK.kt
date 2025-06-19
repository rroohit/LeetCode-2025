package f_june

import java.util.*

/**
 *  Problem 19. Partition Array Such That Maximum Difference Is K.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(nlogn)
 *
 *       - Space complexity: O(Sn)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(intArrayOf(3, 6, 1, 2, 5), 2)
    )

    testCases.forEach { (nums, k) ->
        println("Result ==> ${partitionArray(nums, k)}")
    }

}

fun partitionArray(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    var ans = 1
    var rec = nums[0]
    for (i in nums.indices) {
        if (nums[i] - rec > k) {
            ans++
            rec = nums[i]
        }
    }
    return ans
}
