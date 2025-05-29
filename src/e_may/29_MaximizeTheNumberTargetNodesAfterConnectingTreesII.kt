package e_may

import kotlin.math.max


/**
 *  Problem 29. Maximize the Number of Target Nodes After Connecting Trees II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m)
 *          - where n is the number of nodes, e is the number of edges.
 *
 *       - Space complexity: O(n + m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(2, 3), intArrayOf(2, 4)),
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(0, 3),
                intArrayOf(2, 7),
                intArrayOf(1, 4),
                intArrayOf(4, 5),
                intArrayOf(4, 6)
            )
        )
    )

    testCases.forEach { (edges1, edges2) ->
        println("Result ==> ${maxTargetNodes(edges1, edges2).toList()}")
    }

}

fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>): IntArray {
    val n = edges1.size + 1
    val m = edges2.size + 1
    val color1 = IntArray(n)
    val color2 = IntArray(m)
    val count1 = build(edges1, color1)
    val count2 = build(edges2, color2)
    val res = IntArray(n)
    for (i in 0..<n) {
        res[i] = count1[color1[i]] + max(count2[0], count2[1])
    }
    return res
}

private fun build(edges: Array<IntArray>, color: IntArray): IntArray {
    val n = edges.size + 1
    val children: MutableList<MutableList<Int>> = ArrayList()

    for (i in 0..<n) {
        children.add(ArrayList())
    }

    for (edge in edges) {
        children[edge[0]].add(edge[1])
        children[edge[1]].add(edge[0])
    }

    val res = dfs(0, -1, 0, children, color)
    return intArrayOf(res, n - res)
}

private fun dfs(
    node: Int,
    parent: Int,
    depth: Int,
    children: MutableList<MutableList<Int>>,
    color: IntArray
): Int {
    var res = 1 - (depth % 2)
    color[node] = depth % 2
    for (child in children[node]) {
        if (child == parent) {
            continue
        }
        res += dfs(child, node, depth + 1, children, color)
    }
    return res
}








