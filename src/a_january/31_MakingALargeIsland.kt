package a_january

import kotlin.math.max


/**
 *  Problem 31. Making A Large Island.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O()
 *
 *       - Space complexity: O()
 *
 * ## Code -
 */
fun main() {


}

internal class DisjointSet(n: Int) {
    private var parent: IntArray = IntArray(n)
    var islandSize: IntArray = IntArray(n)

    init {
        for (node in 0..<n) {
            parent[node] = node
            islandSize[node] = 1
        }
    }

    fun findRoot(node: Int): Int {
        if (parent[node] == node) return node
        return findRoot(parent[node]).also { parent[node] = it }
    }

    fun unionNodes(nodeA: Int, nodeB: Int) {
        val rootA = findRoot(nodeA)
        val rootB = findRoot(nodeB)

        if (rootA == rootB) return

        if (islandSize[rootA] < islandSize[rootB]) {
            parent[rootA] = rootB
            islandSize[rootB] += islandSize[rootA]
        } else {
            parent[rootB] = rootA
            islandSize[rootA] += islandSize[rootB]
        }
    }
}

internal class Solution {
    fun largestIsland(grid: Array<IntArray>): Int {
        val rows = grid.size
        val columns = grid[0].size

        val ds = DisjointSet(rows * columns)

        val rowDirections = intArrayOf(1, -1, 0, 0)
        val columnDirections = intArrayOf(0, 0, 1, -1)

        for (currentRow in 0..<rows) {
            for (currentColumn in 0..<columns) {
                if (grid[currentRow][currentColumn] == 1) {
                    val currentNode = (columns * currentRow) + currentColumn

                    for (direction in 0..3) {
                        val neighborRow = currentRow + rowDirections[direction]
                        val neighborColumn =
                            currentColumn + columnDirections[direction]

                        if (neighborRow in 0..<rows && neighborColumn >= 0 && neighborColumn < columns && grid[neighborRow][neighborColumn] == 1
                        ) {
                            val neighborNode =
                                columns * neighborRow + neighborColumn
                            ds.unionNodes(currentNode, neighborNode)
                        }
                    }
                }
            }
        }

        var maxIslandSize = 0
        var hasZero = false
        val uniqueRoots: MutableSet<Int> = HashSet()

        for (currentRow in 0..<rows) {
            for (currentColumn in 0..<columns) {
                if (grid[currentRow][currentColumn] == 0) {
                    hasZero = true
                    var currentIslandSize = 1

                    for (direction in 0..3) {
                        val neighborRow = currentRow + rowDirections[direction]
                        val neighborColumn =
                            currentColumn + columnDirections[direction]

                        if (neighborRow in 0..<rows &&
                            neighborColumn >= 0 &&
                            neighborColumn < columns &&
                            grid[neighborRow][neighborColumn] == 1
                        ) {
                            val neighborNode =
                                columns * neighborRow + neighborColumn
                            val root = ds.findRoot(neighborNode)
                            uniqueRoots.add(root)
                        }
                    }

                    for (root in uniqueRoots) {
                        currentIslandSize += ds.islandSize[root]
                    }

                    uniqueRoots.clear()
                    maxIslandSize = max(maxIslandSize.toDouble(), currentIslandSize.toDouble()).toInt()
                }
            }
        }

        if (!hasZero) return rows * columns
        return maxIslandSize
    }
}