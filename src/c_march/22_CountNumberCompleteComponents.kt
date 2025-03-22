package c_march

import java.util.*


/**
 *  Problem 22. Count the Number of Complete Components.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n  + m⍺(n))
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            6,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(1, 2),
                intArrayOf(3, 4)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${countCompleteComponents(test.first, test.second)}")
    }

}

fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
    val dsu = UnionFind(n)
    val edgeCount: MutableMap<Int, Int> = HashMap()

    for (edge in edges) {
        dsu.union(edge[0], edge[1])
    }

    for (edge in edges) {
        val root = dsu.find(edge[0])
        edgeCount[root] = edgeCount.getOrDefault(root, 0) + 1
    }

    var completeCount = 0
    for (vertex in 0..<n) {
        if (dsu.find(vertex) == vertex) { // If vertex is root
            val nodeCount = dsu.size[vertex]
            val expectedEdges = (nodeCount * (nodeCount - 1)) / 2
            if (edgeCount.getOrDefault(vertex, 0) == expectedEdges) {
                completeCount++
            }
        }
    }
    return completeCount
}

class UnionFind(n: Int) {
    private var parent: IntArray = IntArray(n) { -1 }
    var size: IntArray = IntArray(n) { 1 }

    fun find(node: Int): Int {
        if (parent[node] == -1) {
            return node
        }
        return find(parent[node]).also { parent[node] = it }
    }

    fun union(node1: Int, node2: Int) {
        val root1 = find(node1)
        val root2 = find(node2)
        if (root1 == root2) {
            return
        }
        if (size[root1] > size[root2]) {
            parent[root2] = root1
            size[root1] += size[root2]
        } else {
            parent[root1] = root2
            size[root2] += size[root1]
        }
    }
}