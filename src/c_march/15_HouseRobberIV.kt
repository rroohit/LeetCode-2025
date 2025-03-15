package c_march

import java.util.*


/**
 *  Problem 15. House Robber IV.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n log m)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(2, 3, 5, 9), 2
        ),
        Pair(
            intArrayOf(2, 7, 9, 3, 1), 2
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minCapability(test.first, test.second)}")
    }

}


fun minCapability(nums: IntArray, k: Int): Int {
    var minReward = 1
    var maxReward = Arrays.stream(nums).max().asInt
    val totalHouses = nums.size

    while (minReward < maxReward) {
        val midReward = (minReward + maxReward) / 2
        var possibleThefts = 0
        var index = 0
        while (index < totalHouses) {
            if (nums[index] <= midReward) {
                possibleThefts += 1
                index++
            }
            ++index
        }

        if (possibleThefts >= k) maxReward = midReward
        else minReward = midReward + 1
    }

    return minReward
}