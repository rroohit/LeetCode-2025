package a_january

import kotlin.math.abs

/**
 *  Problem 25. Make Lexicographically Smallest Array by Swapping Elements.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N log N)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 5, 3, 9, 8), 2
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${lexicographicallySmallestArray(test.first, test.second).toList()}")
    }

}

fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
    val sortedNums = nums.sorted()
    val numToInd = HashMap<Int, Int>()
    val groups = mutableListOf<ArrayDeque<Int>>()

    for (num in sortedNums) {
        if (groups.isEmpty() || abs(groups.last().last() - num) > limit) {
            groups.add(ArrayDeque())
        }
        groups.last().add(num)
        numToInd[num] = groups.size - 1
    }

    val result: ArrayList<Int> = ArrayList()
    for (num in nums) {
        val groupInd = numToInd[num]!!
        val group = groups[groupInd]
        result.add(group.removeFirstOrNull()!!)
    }

    return result.toIntArray()
}