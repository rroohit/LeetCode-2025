package c_march


/**
 *  Problem 20. Minimum Cost Walk in Weighted Graph.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m + n + q)
 *
 *       - Space complexity: O(n + m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple(
            5,
            arrayOf(
                intArrayOf(0, 1, 7),
                intArrayOf(1, 3, 7),
                intArrayOf(1, 2, 1)
            ),
            arrayOf(
                intArrayOf(0, 3), intArrayOf(3, 4)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minimumCost(test.first, test.second, test.third).toList()}")
    }

}

fun minimumCost(n: Int, edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
    val adjList: MutableList<MutableList<IntArray>> = ArrayList(n)
    for (i in 0..<n) {
        adjList.add(ArrayList(2))
    }

    for (edge in edges) {
        adjList[edge[0]].add(intArrayOf(edge[1], edge[2]))
        adjList[edge[1]].add(intArrayOf(edge[0], edge[2]))
    }

    val visited = BooleanArray(n)

    val components = IntArray(n)
    val componentCost: MutableList<Int> = ArrayList(n)

    var componentId = 0

    for (node in 0..<n) {
        if (!visited[node]) {
            // Get the component cost and mark all nodes in the component
            componentCost.add(
                getComponentCost(
                    node,
                    adjList,
                    visited,
                    components,
                    componentId
                )
            )
            componentId++
        }
    }

    val answer = IntArray(queries.size)
    for (i in queries.indices) {
        val start = queries[i][0]
        val end = queries[i][1]

        if (components[start] == components[end]) {
            answer[i] = componentCost[components[start]]
        } else {
            answer[i] = -1
        }
    }

    return answer
}

private fun getComponentCost(
    node: Int,
    adjList: List<MutableList<IntArray>>,
    visited: BooleanArray,
    components: IntArray,
    componentId: Int
): Int {
    var currentCost = Int.MAX_VALUE

    components[node] = componentId
    visited[node] = true

    for (neighbor in adjList[node]) {
        val weight = neighbor[1]

        currentCost = currentCost and weight

        if (!visited[neighbor[0]]) {
            currentCost = currentCost and getComponentCost(
                neighbor[0],
                adjList,
                visited,
                components,
                componentId
            )
        }
    }

    return currentCost
}