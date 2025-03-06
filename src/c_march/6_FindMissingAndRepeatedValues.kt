package c_march

/**
 *  Problem 6. Find Missing and Repeated Values.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2)
 *
 *       - Space complexity: O(n^2)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(intArrayOf(1, 3), intArrayOf(2, 2)),
        arrayOf(
            intArrayOf(9, 1, 7),
            intArrayOf(8, 9, 2),
            intArrayOf(3, 4, 6)
        )
    )

    testCases.forEach { grid ->
        println("Result ==> ${findMissingAndRepeatedValues(grid).toList()}")
    }

}

// TC - O(n^2) : SC - O(n^2)
fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
    val n = grid.size
    val cnt = IntArray(n * n + 1) { 0 }
    for (row in grid.indices) {
        for (col in grid[row].indices) {
            cnt[grid[row][col]]++
        }
    }

    var a = 0
    var b = 0
    for (i in 1..<cnt.size) {
        if (cnt[i] == 2) a = i
        if (cnt[i] == 0) b = i
    }
    return intArrayOf(a, b)
}