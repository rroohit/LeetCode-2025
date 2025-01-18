package a_january

import java.util.*


/**
 *  Problem 18. Minimum Cost to Make at Least One Valid Path in a Grid.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * m)
 *
 *       - Space complexity: O(n * m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(1, 1, 1, 1),
            intArrayOf(2, 2, 2, 2),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(2, 2, 2, 2)
        )

    )

    testCases.forEach { grid ->
        println("Result ==> ${minCost(grid)}")
    }

}

private val dirs = arrayOf(
    intArrayOf(0, 1),  // right
    intArrayOf(0, -1), // left
    intArrayOf(1, 0),  // down
    intArrayOf(-1, 0)  // up
)

fun minCost(grid: Array<IntArray>): Int {
    val numRows = grid.size
    val numCols = grid[0].size

    val minCost = Array(numRows) { IntArray(numCols) { Int.MAX_VALUE } }
    val deque = LinkedList<IntArray>()
    deque.offerFirst(intArrayOf(0, 0))
    minCost[0][0] = 0

    while (deque.isNotEmpty()) {
        val curr = deque.pollFirst()
        val row = curr[0]
        val col = curr[1]

        for (dir in dirs.indices) {
            val newRow = row + dirs[dir][0]
            val newCol = col + dirs[dir][1]
            val cost = if (grid[row][col] != dir + 1) 1 else 0

            if (isValid(newRow, newCol, numRows, numCols) &&
                minCost[row][col] + cost < minCost[newRow][newCol]
            ) {
                minCost[newRow][newCol] = minCost[row][col] + cost
                if (cost == 1) {
                    deque.offerLast(intArrayOf(newRow, newCol))
                } else {
                    deque.offerFirst(intArrayOf(newRow, newCol))
                }
            }
        }
    }

    return minCost[numRows - 1][numCols - 1]
}

private fun isValid(row: Int, col: Int, numRows: Int, numCols: Int): Boolean {
    return row in 0..<numRows && col in 0..<numCols
}