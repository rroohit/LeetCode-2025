package a_january

import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

/**
 *  Problem 28. Maximum Number of Fish in a Grid.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * m)
 *
 *       - Space complexity: O(n + m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(0, 2, 1, 0),
            intArrayOf(4, 0, 0, 3),
            intArrayOf(1, 0, 0, 4),
            intArrayOf(0, 3, 2, 0)
        )
    )

    testCases.forEach { grid ->
        println("Result ==> ${findMaxFish(grid)}")
    }

}

private var maxFish = 0
fun findMaxFish(grid: Array<IntArray>): Int {
    val queue: Queue<Cell> = LinkedList()
    for (r in grid.indices) {
        for (c in grid[0].indices) {
            if (grid[r][c] != 0) {
                queue.offer(Cell(r, c))
                maxFish = max(
                    maxFish,
                    dfs(r, c, grid, 0) //bfs(grid, queue)
                )
            }
        }
    }
    return maxFish
}

private fun bfs(grid: Array<IntArray>, queue: Queue<Cell>): Int {
    val row = grid.size
    val col = grid[0].size
    var currMax = 0
    while (queue.isNotEmpty()) {
        val cell = queue.poll()!!
        currMax += grid[cell.r][cell.c]
        grid[cell.r][cell.c] = 0
        if (cell.c - 1 >= 0 && grid[cell.r][cell.c - 1] != 0) { // left
            queue.offer(Cell(cell.r, cell.c - 1))
        }

        if (cell.c + 1 < col && grid[cell.r][cell.c + 1] != 0) { // right
            queue.offer(Cell(cell.r, cell.c + 1))
        }

        if (cell.r - 1 >= 0 && grid[cell.r - 1][cell.c] != 0) { // up
            queue.offer(Cell(cell.r - 1, cell.c))
        }

        if (cell.r + 1 < row && grid[cell.r + 1][cell.c] != 0) { // down
            queue.offer(Cell(cell.r + 1, cell.c))
        }
    }
    return currMax
}

private data class Cell(val r: Int, val c: Int)

private fun dfs(r: Int, c: Int, grid: Array<IntArray>, count: Int): Int {
    if (r < 0 || c < 0 || r >= grid.size || c >= grid[0].size) return count
    if (grid[r][c] == 0) return 0
    val currCellFish = grid[r][c]
    grid[r][c] = 0

    val right = dfs(r, c + 1, grid, count)
    val left = dfs(r, c - 1, grid, count)
    val up = dfs(r - 1, c, grid, count)
    val down = dfs(r + 1, c, grid, count)

    return (right + left + up + down) + currCellFish
}