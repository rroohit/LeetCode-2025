package a_january

import java.util.*
import kotlin.math.max


/**
 *  Problem 19. Trapping Rain Water II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m * n * logm * n)
 *
 *       - Space complexity: O(m * n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(1, 4, 3, 1, 3, 2),
            intArrayOf(3, 2, 1, 3, 2, 4),
            intArrayOf(2, 3, 3, 2, 3, 1)
        ),
        arrayOf(
            intArrayOf(3, 3, 3, 3, 3),
            intArrayOf(3, 2, 2, 2, 3),
            intArrayOf(3, 2, 1, 2, 3),
            intArrayOf(3, 2, 2, 2, 3),
            intArrayOf(3, 3, 3, 3, 3)
        )
    )

    val solution = TrappingWater()

    testCases.forEach { heightMap ->
        println("Result ==> ${solution.trapRainWater(heightMap)}")
    }

}

internal class TrappingWater {
    fun trapRainWater(heightMap: Array<IntArray>): Int {
        val dRow = intArrayOf(0, 0, -1, 1)
        val dCol = intArrayOf(-1, 1, 0, 0)

        val numOfRows = heightMap.size
        val numOfCols = heightMap[0].size

        val visited = Array(numOfRows) { BooleanArray(numOfCols) }

        val boundary = PriorityQueue<Cell>()

        for (i in 0..<numOfRows) {
            boundary.offer(Cell(heightMap[i][0], i, 0))
            boundary.offer(Cell(heightMap[i][numOfCols - 1], i, numOfCols - 1))
            visited[i][numOfCols - 1] = true
            visited[i][0] = visited[i][numOfCols - 1]
        }

        for (i in 0..<numOfCols) {
            boundary.offer(Cell(heightMap[0][i], 0, i))
            boundary.offer(
                Cell(heightMap[numOfRows - 1][i], numOfRows - 1, i)
            )
            visited[numOfRows - 1][i] = true
            visited[0][i] = visited[numOfRows - 1][i]
        }

        var totalWaterVolume = 0

        while (!boundary.isEmpty()) {
            val currentCell = boundary.poll()

            val currentRow = currentCell.row
            val currentCol = currentCell.col
            val minBoundaryHeight = currentCell.height

            for (direction in 0..3) {
                val neighborRow = currentRow + dRow[direction]
                val neighborCol = currentCol + dCol[direction]

                if (isValidCell(
                        neighborRow,
                        neighborCol,
                        numOfRows,
                        numOfCols
                    ) &&
                    !visited[neighborRow][neighborCol]
                ) {
                    val neighborHeight = heightMap[neighborRow][neighborCol]

                    if (neighborHeight < minBoundaryHeight) totalWaterVolume += minBoundaryHeight - neighborHeight

                    boundary.offer(
                        Cell(
                            max(neighborHeight.toDouble(), minBoundaryHeight.toDouble()).toInt(),
                            neighborRow,
                            neighborCol
                        )
                    )
                    visited[neighborRow][neighborCol] = true
                }
            }
        }

        return totalWaterVolume
    }

    private class Cell(var height: Int, var row: Int, var col: Int) : Comparable<Cell> {
        override fun compareTo(other: Cell): Int {
            return this.height.compareTo(other.height)
        }
    }

    private fun isValidCell(
        row: Int,
        col: Int,
        numOfRows: Int,
        numOfCols: Int
    ): Boolean {
        return row >= 0 && col >= 0 && row < numOfRows && col < numOfCols
    }
}


