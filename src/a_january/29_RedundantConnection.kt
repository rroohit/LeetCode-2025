package a_january

import java.util.*


/**
 *  Problem 29. Redundant Connection.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {


    val testCases = listOf(
        arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 3))
    )

    testCases.forEach { edges ->
        println("Result ==> ${findRedundantConnection(edges).toList()}")
    }

}

private var cycleStart = -1
fun findRedundantConnection(edges: Array<IntArray>): IntArray {
    val n = edges.size
    val visited = BooleanArray(n)
    val parent = IntArray(n)
    Arrays.fill(parent, -1)

    val adjList = Array<MutableList<Int>>(n) { mutableListOf() }
    for (edge in edges) {
        adjList[edge[0] - 1].add(edge[1] - 1)
        adjList[edge[1] - 1].add(edge[0] - 1)
    }

    dFS(0, visited, adjList, parent)

    val cycleNodes: MutableMap<Int, Int> = HashMap()
    var node = cycleStart
    do {
        cycleNodes[node] = 1
        node = parent[node]
    } while (node != cycleStart)

    for (i in edges.indices.reversed()) {
        if (cycleNodes.containsKey(edges[i][0] - 1) &&
            cycleNodes.containsKey(edges[i][1] - 1)
        ) {
            return edges[i]
        }
    }

    return intArrayOf()
}

private fun dFS(
    src: Int,
    visited: BooleanArray,
    adjList: Array<MutableList<Int>>,
    parent: IntArray
) {
    visited[src] = true
    for (adj in adjList[src]) {
        if (!visited[adj]) {
            parent[adj] = src
            dFS(adj, visited, adjList, parent)
        } else if (adj != parent[src] && cycleStart == -1) {
            cycleStart = adj
            parent[adj] = src
        }
    }
}

