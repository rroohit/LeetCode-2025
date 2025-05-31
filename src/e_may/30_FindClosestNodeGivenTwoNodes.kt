package e_may

import kotlin.math.max

/**
 *  Problem 30. Find Closest Node to Given Two Nodes.
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
        Data30(
            intArrayOf(2, 2, 3, -1),
            0, 2
        )
    )

    testCases.forEach { (edges, node1, node2) ->
        println("Result ==> ${closestMeetingNode(edges, node1, node2)}")
    }
}

fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
    val n = edges.size
    val dist1 = IntArray(n) { Int.MAX_VALUE }
    val dist2 = IntArray(n) { Int.MAX_VALUE }
    dist1[node1] = 0
    dist2[node2] = 0

    val visit1 = BooleanArray(n)
    val visit2 = BooleanArray(n)

    dfs(node1, edges, dist1, visit1)
    dfs(node2, edges, dist2, visit2)

    var minDistNode = -1
    var minDistTillNow = Int.MAX_VALUE
    for (currNode in 0..<n) {
        if (minDistTillNow > max(dist1[currNode], dist2[currNode])) {
            minDistNode = currNode
            minDistTillNow = max(dist1[currNode], dist2[currNode])
        }
    }

    return minDistNode
}

fun dfs(node: Int, edges: IntArray, dist: IntArray, visit: BooleanArray) {
    visit[node] = true
    val neighbor = edges[node]
    if (neighbor != -1 && !visit[neighbor]) {
        dist[neighbor] = 1 + dist[node]
        dfs(neighbor, edges, dist, visit)
    }
}

private data class Data30(
    val edges: IntArray,
    val node1: Int,
    val node2: Int,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Data30

        if (node1 != other.node1) return false
        if (node2 != other.node2) return false
        if (!edges.contentEquals(other.edges)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = node1
        result = 31 * result + node2
        result = 31 * result + edges.contentHashCode()
        return result
    }
}