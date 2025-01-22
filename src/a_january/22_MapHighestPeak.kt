package a_january

import java.util.*


/**
 *  Problem 22. Map of Highest Peak.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m * n)
 *
 *       - Space complexity: O(m * n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 0)
        ),
        arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(1, 0, 0),
            intArrayOf(0, 0, 0)
        )
    )

    testCases.forEach { isWater ->
        println("Result ==> ${highestPeak(isWater)}")
    }

}

fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    val rows = isWater.size
    val columns = isWater[0].size

    val cellHeights = Array(rows) { IntArray(columns) { -1 } }
    val cellQueue: Queue<IntArray> = LinkedList()
    for (x in 0..<rows) {
        for (y in 0..<columns) {
            if (isWater[x][y] == 1) {
                cellQueue.add(intArrayOf(x, y))
                cellHeights[x][y] = 0
            }
        }
    }

    var heightOfNextLayer = 1

    while (!cellQueue.isEmpty()) {
        val layerSize = cellQueue.size

        for (i in 0..<layerSize) {
            val currentCell = cellQueue.poll()

            for (d in 0..3) {
                val neighborX = currentCell[0] + dx[d]
                val neighborY = currentCell[1] + dy[d]
                if (isValidCell(neighborX, neighborY, rows, columns) &&
                    cellHeights[neighborX][neighborY] == -1
                ) {
                    cellHeights[neighborX][neighborY] = heightOfNextLayer
                    cellQueue.add(intArrayOf(neighborX, neighborY))
                }
            }
        }
        heightOfNextLayer++
    }

    return cellHeights
}

private fun isValidCell(x: Int, y: Int, rows: Int, columns: Int): Boolean {
    return x >= 0 && y >= 0 && x < rows && y < columns
}