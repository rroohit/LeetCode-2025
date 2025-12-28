package l_december

fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(4, 3, 2, -1),
            intArrayOf(3, 2, 1, -1),
            intArrayOf(1, 1, -1, -2),
            intArrayOf(-1, -1, -2, -3)
        )
    )

    testCases.forEach { grid ->
        println("Result ==> ${countNegatives(grid)}")
    }

}

// TC - O(n + m) : SC - O(1)
fun countNegatives(grid: Array<IntArray>): Int {
    val m = grid.size // row size
    val n = grid[0].size // column size
    var cr = 0 // curr Row
    var cc = n - 1 // curr Column
    var cnt = 0
    while (cr < m && cc >= 0) {
        if (grid[cr][cc] < 0) {
            cnt += m - cr
            cc--
        } else {
            cr++
        }
    }
    return cnt
}


// TC - O(n * log m) : SC - O(1)
fun countNegatives2(grid: Array<IntArray>): Int {
    val rowSize = grid[0].size
    var cnt = 0
    for (row in grid) {
        var l = 0
        var r = rowSize - 1
        while (l < r) {
            val m = l + (r - l) / 2
            if (row[m] < 0) {
                r = m
            } else {
                l = m + 1
            }
        }
        if (row[r] < 0) cnt += rowSize - r
    }
    return cnt
}

// TC - O(m * n) : SC - O(1)
fun countNegatives1(grid: Array<IntArray>): Int {
    var cnt = 0
    for (r in 0..<grid.size) {
        for (c in 0..<grid[0].size) {
            if (grid[r][c] < 0) cnt++
        }
    }
    return cnt
}