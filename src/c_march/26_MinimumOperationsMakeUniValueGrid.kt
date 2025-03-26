package c_march

import kotlin.math.abs

/**
 *  Problem 26. Minimum Operations to Make a Uni-Value Grid.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(mn log mn)
 *
 *       - Space complexity: O(mn)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            2,
            arrayOf(
                intArrayOf(2, 4),
                intArrayOf(6, 8)
            )
        ),
        Pair(
            1,
            arrayOf(
                intArrayOf(1, 5),
                intArrayOf(2, 3)
            )
        ),
        Pair(
            2,
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 4)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minOperations(test.second, test.first)}")
    }

}

// TC - O(mn * log mn) :: SC - O(mn)
fun minOperations(grid: Array<IntArray>, x: Int): Int {
    val flatNums = ArrayList<Int>()
    for (row in grid.indices) {
        for (col in grid[row].indices) {
            flatNums.add(grid[row][col])
        }
    }
    flatNums.sort()
    var operations = 0
    val commonNum = flatNums[flatNums.size / 2]
    for (num in flatNums) {
        if (num % x != commonNum % x) return -1
        operations += abs(commonNum - num) / x
    }
    return operations
}