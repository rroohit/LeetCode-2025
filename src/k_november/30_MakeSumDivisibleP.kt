package k_november

import kotlin.math.min

/**
 *  Problem 30. Make Sum Divisible by P.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O()
 *       - Space complexity: O()
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(3, 1, 4, 2), 6
        )
    )

    testCases.forEach { (nums, p) ->
        println("Result ==> ${minSubarray(nums, p)}")
    }

}

fun minSubarray(nums: IntArray, p: Int): Int {
    val n = nums.size
    var totalSumModP = 0
    for (num in nums) {
        totalSumModP = (totalSumModP + num) % p
    }

    val target = totalSumModP
    if (target == 0) {
        return 0
    }

    val modMap = HashMap<Int, Int>()
    modMap[0] = -1

    var currentSumModP = 0
    var minLen = n

    for (i in 0 until n) {
        currentSumModP = (currentSumModP + nums[i]) % p
        val needed = (currentSumModP - target + p) % p
        if (modMap.containsKey(needed)) {
            val j = modMap[needed]!!
            minLen = min(minLen, i - j)
        }
        modMap[currentSumModP] = i
    }

    return if (minLen == n) -1 else minLen
}