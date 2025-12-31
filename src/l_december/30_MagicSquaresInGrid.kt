package l_december

fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(4, 3, 8, 4),
            intArrayOf(9, 5, 1, 9),
            intArrayOf(2, 7, 6, 2)
        )
    )

    testCases.forEach { grid ->
        println("Result ==> ${numMagicSquaresInside(grid)}")
    }

}

fun numMagicSquaresInside(grid: Array<IntArray>): Int {
    val rowSize = grid.size
    val colSize = grid[0].size

    var magicCount = 0
    for (r in 0..rowSize - 3) {
        for (c in 0..colSize - 3) {
            if (isMagicCell(r, c, grid)) magicCount++
        }
    }

    return magicCount
}

private fun isMagicCell(r: Int, c: Int, grid: Array<IntArray>): Boolean {
    val seen = HashSet<Int>()
    for (r1 in r..r + 2) {
        for (c1 in c..c + 2) {
            val num = grid[r1][c1]
            if (num !in 1..9 || seen.contains(num)) return false
            seen.add(num)
        }
    }

    for (r1 in r..r + 2) if (grid[r1][c] + grid[r1][c + 1] + grid[r1][c + 2] != 15) return false

    for (c1 in c..c + 2) if (grid[r][c1] + grid[r + 1][c1] + grid[r + 2][c1] != 15) return false

    val diagonal1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2]
    val diagonal2 = grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]
    if (diagonal1 != diagonal2) return false
    return diagonal1 == 15
}

class Solution30 {
    private lateinit var mGrid: Array<IntArray>
    fun numMagicSquaresInside(grid: Array<IntArray>): Int {
        mGrid = grid
        var magicSq = 0
        val row = mGrid.size
        val col = mGrid[0].size
        if (row < 3 || col < 3) return 0

        for (r in 1.. row - 2) {
            for (c in 1.. col - 2) if (isMagicSq(r, c)) magicSq++
        }

        return magicSq
    }

    private fun isMagicSq(r: Int, c: Int) : Boolean {
        val seen = BooleanArray(10) { false }
        for (r in r - 1..r + 1) {
            var rowSum = 0
            for (c in c - 1 .. c + 1) {
                val num = mGrid[r][c]
                if (num !in 1..9 || seen[num]) return false
                seen[num] = true
                rowSum += num
            }
            if (rowSum != 15) return false
        }

        val digOne = mGrid[r][c] + mGrid[r - 1][c - 1] + mGrid[r + 1][c + 1]
        val digTwo = mGrid[r][c] + mGrid[r - 1][c + 1] + mGrid[r + 1][c - 1]
        if (digOne != 15 || digTwo != 15) return false

        for (c in c - 1..c + 1) {
            var colSum = 0
            for (r in r - 1..r + 1) colSum += mGrid[r][c]
            if (colSum != 15) return false
        }

        return true
    }
}