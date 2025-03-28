package c_march

import java.util.*

/**
 *  Problem 28. Maximum Number of Points From Grid Queries.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O()
 *
 *       - Space complexity: O()
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(2, 5, 7),
                intArrayOf(3, 5, 1)
            ),
            intArrayOf(5, 6, 2)
        ),
        Pair(
            arrayOf(
                intArrayOf(5, 2, 1),
                intArrayOf(1, 1, 2)
            ),
            intArrayOf(3)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${maxPoints(test.first, test.second).toList()}")
    }

}

// Unsolved
private lateinit var visitedCells: Array<BooleanArray>
fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
    val m = grid.size
    val n = grid[0].size
    visitedCells = Array(m) { BooleanArray(n) { false } }

    val prQu = PriorityQueue<Pair<Int, Int>>(compareBy { it.first }) // Min-Heap : (value, index)
    for (i in queries.indices) prQu.add(Pair(queries[i], i))

    var points = 0
    var lastCell = Cell(0, 0)
    while (prQu.isNotEmpty()) {
        val query = prQu.poll() ?: break
        val currQueryPoints = getPoints(grid, query.first, lastCell)
        points += currQueryPoints.first
        lastCell = currQueryPoints.second
        queries[query.second] = points
    }

    return queries
}

private fun getPoints(grid: Array<IntArray>, query: Int, startCell: Cell): Pair<Int, Cell> {
    val m = grid.size // row
    val n = grid[0].size // column
    var points = 0
    var lastCell = startCell
    val queue = LinkedList<Cell>()
    queue.add(startCell)
    while (queue.isNotEmpty()) {
        val cell = queue.poll() ?: break
        val r = cell.r
        val c = cell.c

        if (visitedCells[r][c]) continue

        if (grid[r][c] >= query) {
            lastCell = cell
            continue
        }
        visitedCells[r][c] = true
        points++

        // right
        if (c + 1 < n) queue.add(Cell(r, c + 1))
        // left
        if (c - 1 >= 0) queue.add(Cell(r, c - 1))
        // top
        if (r - 1 >= 0) queue.add(Cell(r - 1, c))
        // bottom
        if (r + 1 < m) queue.add(Cell(r + 1, c))
    }

    return Pair(points, lastCell)
}

private data class Cell(
    val r: Int, // Row index
    val c: Int  // Column index
)

private class Solution28 {
    // TLE
    // TC - O(q * (m * n)) :: SC - O(m * n)
    fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
        for (i in queries.indices) {
            queries[i] = getPoints(grid, queries[i])
        }
        return queries
    }

    private fun getPoints(grid: Array<IntArray>, query: Int): Int {
        val m = grid.size // row
        val n = grid[0].size // column
        val visited = Array(m) { BooleanArray(n) { false } }
        var points = 0
        val queue = LinkedList<Cell>()
        queue.add(Cell(0, 0))
        while (queue.isNotEmpty()) {
            val cell = queue.poll() ?: break
            val r = cell.r
            val c = cell.c
            if (visited[r][c] || grid[r][c] >= query) continue
            visited[r][c] = true
            points++
            // right
            if (c + 1 < n && !visited[r][c + 1]) queue.add(Cell(r, c + 1))
            // left
            if (c - 1 >= 0 && !visited[r][c - 1]) queue.add(Cell(r, c - 1))
            // top
            if (r - 1 >= 0 && !visited[r - 1][c]) queue.add(Cell(r - 1, c))
            // bottom
            if (r + 1 < m && !visited[r + 1][c]) queue.add(Cell(r + 1, c))
        }
        return points
    }


}
