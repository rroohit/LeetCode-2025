package b_february

import kotlin.math.max
import kotlin.math.min


/**
 *  Problem 24. Most Profitable Path in a Tree.
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
        Triple(
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(3, 4)),
            3,
            intArrayOf(-2, 4, 2, -4, 6)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${mostProfitablePath(test.first, test.second, test.third)}")
    }

}

private var tree: ArrayList<ArrayList<Int>> = ArrayList()
private lateinit var distanceFromBob: IntArray
private var n = 0
fun mostProfitablePath(edges: Array<IntArray>, bob: Int, amount: IntArray): Int {
    n = amount.size
    tree = ArrayList()
    for (i in 0..<n) {
        tree.add(ArrayList())
    }
    distanceFromBob = IntArray(n)

    for (edge in edges) {
        tree[edge[0]].add(edge[1])
        tree[edge[1]].add(edge[0])
    }

    return findPaths(0, 0, 0, bob, amount)
}

private fun findPaths(
    sourceNode: Int,
    parentNode: Int,
    time: Int,
    bob: Int,
    amount: IntArray
): Int {
    var maxIncome = 0
    var maxChild = Int.MIN_VALUE

    if (sourceNode == bob) {
        distanceFromBob[sourceNode] = 0
    } else {
        distanceFromBob[sourceNode] = n
    }

    for (adjacentNode in tree[sourceNode]) {
        if (adjacentNode != parentNode) {
            maxChild = max(
                maxChild,
                findPaths(adjacentNode, sourceNode, time + 1, bob, amount)
            )
            distanceFromBob[sourceNode] = min(
                distanceFromBob[sourceNode],
                (distanceFromBob[adjacentNode] + 1)
            )
        }
    }

    if (distanceFromBob[sourceNode] > time) {
        maxIncome += amount[sourceNode]
    } else if (distanceFromBob[sourceNode] == time) {
        maxIncome += amount[sourceNode] / 2
    }

    return if (maxChild == Int.MIN_VALUE) maxIncome else maxIncome + maxChild
}