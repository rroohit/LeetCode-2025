package e_may

/**
 *  Problem 28.  Maximize the Number of Target Nodes After Connecting Trees I.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2 + m^2)
 *          - where n is the number of nodes, e is the number of edges.
 *
 *       - Space complexity: O(n + m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple(
            arrayOf(
                intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(2, 3), intArrayOf(2, 4)
            ),
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(0, 3),
                intArrayOf(2, 7),
                intArrayOf(1, 4),
                intArrayOf(4, 5),
                intArrayOf(4, 6)
            ), 2
        )
    )

    testCases.forEach { (edges1, edges2, k) ->
        println("Result ==> ${maxTargetNodes(edges1, edges2, k).toList()}")
    }

}

fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>, k: Int): IntArray {
    val n = edges1.size + 1
    val count1 = build(edges1, k)
    val count2 = build(edges2, k - 1)

    val maxCount2 = count2.maxOrNull() ?: 0

    return IntArray(n) { i -> count1[i] + maxCount2 }
}

private fun build(edges: Array<IntArray>, k: Int): IntArray {
    val n = edges.size + 1
    val children = List(n) { mutableListOf<Int>() }

    for (edge in edges) {
        children[edge[0]].add(edge[1])
        children[edge[1]].add(edge[0])
    }

    return IntArray(n) { i -> dfs(i, -1, children, k) }
}

private fun dfs(node: Int, parent: Int, children: List<List<Int>>, k: Int): Int {
    if (k < 0) return 0

    var res = 1
    for (child in children[node]) {
        if (child == parent) continue
        res += dfs(child, node, children, k - 1)
    }
    return res
}