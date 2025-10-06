package j_october

import java.util.*
import kotlin.math.max

/**
 *  Problem 6. Swim in Rising Water.
 *
 *  ## Intuition -
 *      We need to find the minimum time to reach the bottom-right cell.
 *      This is equivalent to finding a path where the maximum elevation along the path is minimized,
 *          because water must rise to at least that height to allow the path.
 *
 *  ## Approach -
 *      - Use a min-heap (priority queue) to always explore the next cell with the lowest height.
 *      - Keep track of the maximum height encountered so far (`maxHt`).
 *      - For each popped cell, push its unvisited neighbors into the heap.
 *      - Once the destination is reached, `maxHt` gives the minimum time required.
 *
 *  ## Complexity:
 *       - Time complexity: O(N^2 * log(N^2)) = O(N^2 log N),
 *         where N is grid size, because each cell is processed once in the heap.
 *       - Space complexity: O(N^2) for the visited array and heap.
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(0, 2),
            intArrayOf(1, 3)
        )
    )

    testCases.forEach { grid ->
        println("Result ==> ${swimInWater(grid)}")
    }

}

fun swimInWater(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return 0
    val direction = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
    val n = grid.size
    val vis = Array(n) { BooleanArray(n) } // Visited
    var maxHt = 0 // Max Height
    val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.first }) // (height, row, col)
    pq.offer(Triple(grid[0][0], 0, 0))
    vis[0][0] = true

    while (pq.isNotEmpty()) {
        val (ht, r, c) = pq.poll() ?: break
        maxHt = max(maxHt, ht)

        if (r == n - 1 && c == n - 1) return maxHt

        for ((dr, dc) in direction) {
            val nr = r + dr
            val nc = c + dc
            if (nr in 0 until n && nc in 0 until n && !vis[nr][nc]) {
                vis[nr][nc] = true
                pq.offer(Triple(grid[nr][nc], nr, nc))
            }
        }

    }
    return maxHt
}

