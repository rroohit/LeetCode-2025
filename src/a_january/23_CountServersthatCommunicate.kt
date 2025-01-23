package a_january

/**
 *  Problem 23. Count Servers that Communicate.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m * n)
 *
 *       - Space complexity: O(m * n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1)
        ),
        arrayOf(
            intArrayOf(1, 0),
            intArrayOf(1, 1)
        ),
        arrayOf(intArrayOf(1, 1, 1, 1))
    )

    testCases.forEach { grid ->
        println("Result ==> ${countServers(grid)}")
        println()
    }

}

fun countServers(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return 0

    val colServers = IntArray(grid.size) { 0 }
    val rowServers = IntArray(grid[0].size) { 0 }
    for (row in grid.indices) {
        for (col in grid[row].indices) {
            if (grid[row][col] == 0) continue
            rowServers[col]++
            colServers[row]++
        }
    }

    var connected = 0
    for (row in grid.indices) {
        for (col in grid[0].indices) {
            if (grid[row][col] == 1) {
                if (rowServers[col] > 1 || colServers[row] > 1) {
                    connected++
                }
            }
        }
    }

    return connected
}