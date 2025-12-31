package l_december

fun main() {

    val testCases = listOf(
        Triple(
            2, 2,
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(2, 1),
                intArrayOf(1, 2),
                intArrayOf(2, 2)
            )
        )
    )

    testCases.forEach { (row, col, cells) ->
        val solution = Solution31()
        println("Result ==> ${solution.latestDayToCross(row, col, cells)}")

    }

}

class Solution31 {
    fun latestDayToCross(row: Int, col: Int, cells: Array<IntArray>): Int {
        var left = 1
        var right = cells.size
        var ans = 0

        while (left <= right) {
            val mid = (left + right) / 2
            if (canCross(row, col, cells, mid)) {
                ans = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return ans
    }

    private fun canCross(
        row: Int,
        col: Int,
        cells: Array<IntArray>,
        day: Int
    ): Boolean {
        val grid = Array(row) { BooleanArray(col) }

        // Mark flooded cells
        for (i in 0 until day) {
            val r = cells[i][0] - 1
            val c = cells[i][1] - 1
            grid[r][c] = true
        }

        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()
        val visited = Array(row) { BooleanArray(col) }

        // Start from top row
        for (c in 0 until col) {
            if (!grid[0][c]) {
                queue.add(0 to c)
                visited[0][c] = true
            }
        }

        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        while (queue.isNotEmpty()) {
            val (r, c) = queue.removeFirst()
            if (r == row - 1) return true

            for (d in dirs) {
                val nr = r + d[0]
                val nc = c + d[1]
                if (nr in 0 until row &&
                    nc in 0 until col &&
                    !grid[nr][nc] &&
                    !visited[nr][nc]
                ) {
                    visited[nr][nc] = true
                    queue.add(nr to nc)
                }
            }
        }
        return false
    }
}
