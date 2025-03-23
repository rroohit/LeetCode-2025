package c_march

import java.util.*

/**
 *  Problem 23. Number of Ways to Arrive at Destination.
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

    val testCases = listOf(
        Pair(
            7,
            arrayOf(
                intArrayOf(0, 6, 7),
                intArrayOf(0, 1, 2),
                intArrayOf(1, 2, 3),
                intArrayOf(1, 3, 3),
                intArrayOf(6, 3, 3),
                intArrayOf(3, 5, 1),
                intArrayOf(6, 5, 1),
                intArrayOf(2, 5, 1),
                intArrayOf(0, 4, 5),
                intArrayOf(4, 6, 2)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${countPaths(test.first, test.second)}")
    }

}

fun countPaths(n: Int, roads: Array<IntArray>): Int {
    val MOD = 1000000007
    val graph: MutableList<MutableList<IntArray>> = ArrayList()
    for (i in 0..<n) {
        graph.add(ArrayList())
    }
    for (road in roads) {
        val startNode = road[0]
        val endNode = road[1]
        val travelTime = road[2]
        graph[startNode].add(intArrayOf(endNode, travelTime))
        graph[endNode].add(intArrayOf(startNode, travelTime))
    }

    val minHeap = PriorityQueue(
        Comparator.comparingLong { a: LongArray -> a[0] }
    )

    val shortestTime = LongArray(n)
    Arrays.fill(shortestTime, Long.MAX_VALUE)

    val pathCount = IntArray(n)

    shortestTime[0] = 0
    pathCount[0] = 1

    minHeap.offer(longArrayOf(0, 0))

    while (!minHeap.isEmpty()) {
        val top = minHeap.poll()
        val currTime = top[0]
        val currNode = top[1].toInt()

        if (currTime > shortestTime[currNode]) {
            continue
        }

        for (neighbor in graph[currNode]) {
            val neighborNode = neighbor[0]
            val roadTime = neighbor[1]
            if (currTime + roadTime < shortestTime[neighborNode]) {
                shortestTime[neighborNode] = currTime + roadTime
                pathCount[neighborNode] = pathCount[currNode]
                minHeap.offer(
                    longArrayOf(shortestTime[neighborNode], neighborNode.toLong())
                )
            } else if (currTime + roadTime == shortestTime[neighborNode]) {
                pathCount[neighborNode] =
                    (pathCount[neighborNode] + pathCount[currNode]) % MOD
            }
        }
    }

    return pathCount[n - 1]
}