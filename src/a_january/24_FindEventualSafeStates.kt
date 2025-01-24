package a_january

import java.util.*


/**
 *  Problem 24. Find Eventual Safe States.
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
            intArrayOf(1, 2),
            intArrayOf(2, 4),
            intArrayOf(5),
            intArrayOf(0),
            intArrayOf(5),
            intArrayOf(),
            intArrayOf()
        )
    )


    testCases.forEach { graph ->
        println("Result ==> ${eventualSafeNodes(graph)}")
    }

}

fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
    val n: Int = graph.size
    val indegree = IntArray(n)
    val adj: MutableList<MutableList<Int>> = ArrayList()

    for (i in 0..<n) {
        adj.add(ArrayList())
    }

    for (i in 0..<n) {
        for (node in graph[i]) {
            adj[node].add(i)
            indegree[i]++
        }
    }

    val q: Queue<Int> = LinkedList()
    for (i in 0..<n) {
        if (indegree[i] == 0) {
            q.add(i)
        }
    }

    val safe = BooleanArray(n)
    while (!q.isEmpty()) {
        val node = q.poll()
        safe[node] = true

        for (neighbor in adj[node]) {
            indegree[neighbor]--
            if (indegree[neighbor] == 0) {
                q.add(neighbor)
            }
        }
    }

    val safeNodes: MutableList<Int> = ArrayList()
    for (i in 0..<n) {
        if (safe[i]) {
            safeNodes.add(i)
        }
    }
    return safeNodes
}