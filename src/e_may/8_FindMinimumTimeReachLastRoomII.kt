package e_may

import java.util.*
import kotlin.math.max


/**
 *  Problem 8. Find Minimum Time to Reach Last Room II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * m * log(n * m))
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
        val solution = Solution8()
        println("Result ==> ${solution.minTimeToReach(moveTime)}")
    }

}

internal class Solution8 {
    inner class State(var x: Int, var y: Int, private var dis: Int) : Comparable<State> {
        override fun compareTo(other: State): Int {
            return this.dis.compareTo(other.dis)
        }
    }

    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val n = moveTime.size
        val m = moveTime[0].size
        val d = Array(n) { IntArray(m) { INF } }
        val v = Array(n) { BooleanArray(m) }

        d[0][0] = 0
        val q = PriorityQueue<State>()
        q.offer(State(0, 0, 0))

        while (!q.isEmpty()) {
            val s = q.poll()
            if (v[s.x][s.y]) continue
            if (s.x == n - 1 && s.y == m - 1) break
            v[s.x][s.y] = true

            for (dir in dirs) {
                val nx = s.x + dir[0]
                val ny = s.y + dir[1]
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue

                val dist = (max(d[s.x][s.y], moveTime[nx][ny]) + ((s.x + s.y) % 2) + 1)
                if (d[nx][ny] > dist) {
                    d[nx][ny] = dist
                    q.offer(State(nx, ny, dist))
                }
            }
        }
        return d[n - 1][m - 1]
    }

    companion object {
        private const val INF = 0x3f3f3f3f
        private val dirs = arrayOf(
            intArrayOf(1, 0), intArrayOf(-1, 0),
            intArrayOf(0, 1), intArrayOf(0, -1)
        )
    }
}