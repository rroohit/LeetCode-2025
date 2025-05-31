package e_may

import java.util.LinkedList
import java.util.Queue

/**
 *  Problem 31. Snakes and Ladders.
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
        arrayOf(
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, 35, -1, -1, 13, -1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, 15, -1, -1, -1, -1)
        )
    )

    testCases.forEach { board ->
        println("Result ==> ${snakesAndLadders(board)}")
    }

}

fun snakesAndLadders(board: Array<IntArray>): Int {
    val n = board.size
    val visited = BooleanArray(n * n + 1)

    fun getCoordinates(pos: Int): Pair<Int, Int> {
        val r = (pos - 1) / n
        val c = (pos - 1) % n
        val row = n - 1 - r
        val col = if (row % 2 == n % 2) n - 1 - c else c
        return row to col
    }

    val queue: Queue<Int> = LinkedList()
    queue.add(1)
    visited[1] = true
    var moves = 0

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()
            if (curr == n * n) return moves

            for (dice in 1..6) {
                val next = curr + dice
                if (next > n * n) continue
                val (row, col) = getCoordinates(next)
                val dest = if (board[row][col] != -1) board[row][col] else next
                if (!visited[dest]) {
                    visited[dest] = true
                    queue.add(dest)
                }
            }
        }
        moves++
    }

    return -1
}