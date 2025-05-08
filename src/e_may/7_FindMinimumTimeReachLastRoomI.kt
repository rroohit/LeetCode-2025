package e_may

import java.util.*
import kotlin.math.max


/**
 *  Problem 7. Find Minimum Time to Reach Last Room I.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * m * log(n * m)).
 *
 *       - Space complexity: O(n * m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(0, 4),
            intArrayOf(4, 4)
        ),
        arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
    )

    testCases.forEach { moveTime ->
        println("Result ==> ${minTimeToReach(moveTime)}")
    }

}

private fun minTimeToReach(moveTime: Array<IntArray>): Int {
    val n = moveTime.size
    val m = moveTime[0].size
    val d = Array(n) { IntArray(m) { 0x3f3f3f3f } }
    val v = Array(n) { BooleanArray(m) }
    val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

    d[0][0] = 0
    val q = PriorityQueue<State>()
    q.offer(State(0, 0, 0))

    while (!q.isEmpty()) {
        val s = q.poll()
        if (v[s.x][s.y]) {
            continue
        }
        v[s.x][s.y] = true
        for (dir in dirs) {
            val nx = s.x + dir[0]
            val ny = s.y + dir[1]
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue
            }
            val dist = (max(d[s.x][s.y], moveTime[nx][ny]) + 1)
            if (d[nx][ny] > dist) {
                d[nx][ny] = dist
                q.offer(State(nx, ny, dist))
            }
        }
    }
    return d[n - 1][m - 1]
}

private data class State(val x: Int, val y: Int, val time: Int) : Comparable<State> {
    override fun compareTo(other: State): Int = this.time - other.time
}

