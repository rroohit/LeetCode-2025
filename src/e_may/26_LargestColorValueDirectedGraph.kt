package e_may

/**
 *  Problem 26. Largest Color Value in a Directed Graph.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + e * 26)
 *          - where n is the number of nodes, e is the number of edges.
 *
 *       - Space complexity: O(n * 26 + n + e)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            "abaca",
            arrayOf(
                intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(2, 3), intArrayOf(3, 4)
            )
        )
    )

    testCases.forEach { (colors, edges) ->
        println("Result ==> ${largestPathValue(colors, edges)}")
    }

}

fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
    val n = colors.length
    val graph = Array<MutableList<Int>>(n) { mutableListOf() }
    val indegree = IntArray(n)

    for ((u, v) in edges) {
        graph[u].add(v)
        indegree[v]++
    }

    val dp = Array(n) { IntArray(26) }
    val queue: ArrayDeque<Int> = ArrayDeque()

    for (i in 0..<n) {
        if (indegree[i] == 0) {
            queue.add(i)
        }
    }

    var visited = 0
    var maxColorValue = 0

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        visited++

        val colorIndex = colors[node] - 'a'
        dp[node][colorIndex]++
        maxColorValue = maxOf(maxColorValue, dp[node][colorIndex])

        for (neighbor in graph[node]) {
            for (c in 0..<26) {
                dp[neighbor][c] = maxOf(dp[neighbor][c], dp[node][c])
            }
            indegree[neighbor]--
            if (indegree[neighbor] == 0) {
                queue.add(neighbor)
            }
        }
    }

    return if (visited < n) -1 else maxColorValue
}